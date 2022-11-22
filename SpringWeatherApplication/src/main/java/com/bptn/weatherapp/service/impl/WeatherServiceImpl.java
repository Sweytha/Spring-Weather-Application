package com.bptn.weatherapp.service.impl;

import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.Weather;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.repository.WeatherRepository;
import com.bptn.weatherapp.response.WeatherApiResponse;
import com.bptn.weatherapp.service.WeatherService;
import com.bptn.weatherapp.util.ResponseToEntityMapping;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService  {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CityRepository cityRepository;
    
    @Value("${api.key}")
    private String apiKey;

    @Value("${api.base.url}")
    private String apiBaseUrl;

    @Override
    public List<Weather> findWeatherByCityName(String cityName) throws Exception {
    	LOGGER.debug("finding Weather Objects into database for city = {}", cityName);
        City city = cityRepository.findCityByName(cityName);
        if (city == null) {
            throw new Exception("City doesn't exit");
        }
        List<Weather> weatherList = weatherRepository.findWeatherByCityID(city);
        if (weatherList == null || weatherList.isEmpty()) {
            throw new Exception("No Weather exist");
        }
        return weatherList;
    }

    @Override
    public Weather findWeatherById(int id) throws Exception{
    	LOGGER.debug("finding Weather Objects into database for Id = {}", id);
        Weather weather = weatherRepository.findWeatherById(id);
        if (weather == null) {
            throw new Exception("No Weather exist");
        }
        return weather;
    }

    @Override
    public List<Weather> findWeatherByUpdatedOn(String updatedOn) throws Exception{
    	LOGGER.debug("finding Weather Objects into database for updatedOn = {}", updatedOn);
        Instant date = Instant.parse(updatedOn);
        List<Weather> weatherList = weatherRepository.findWeatherByUpdatedOn(date);
        if (weatherList == null || weatherList.isEmpty()) {
            throw new Exception("No Weather exist");
        }
        return weatherList;
    }

    @Override
    public Weather createWeather(Weather weather) throws Exception{
    	LOGGER.debug("Creating Weather = {}", weather);
        return weatherRepository.save(weather);
    }

    @Override
    public List<Weather> getWeatherFromWeatherAPI(String query) throws Exception {
    	String url = buildApiUrl(query);
        String weatherJsonString = getWeatherFromOpenWeatherAPI(url);
        List<Weather> resultList = new LinkedList<>();
        WeatherApiResponse weatherApiResponse = parseWeather(weatherJsonString);
        Weather weather = ResponseToEntityMapping.weatherResponseMappingToWeatherEntity(weatherApiResponse);
        resultList.add(weather);
        cityRepository.save(weather.getCityID());
        weatherRepository.save(weather);
        return resultList;
    }
    
    @Override
    public List<Weather> findWeatherByCreatedOnBetween(String from, String to) throws Exception {
        LOGGER.debug("Finding Weather data from = {}  to = {}", from, to);
        return weatherRepository.findWeatherByCreatedOnBetween(Instant.parse(from), Instant.parse(to));
    }
    
    private String getWeatherFromOpenWeatherAPI(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(result);
        String prettyJsonString = gson.toJson(jsonElement);
        return prettyJsonString;
    }
    
    private WeatherApiResponse parseWeather(String weatherJsonString) {
        JsonElement jsonElement = JsonParser.parseString(weatherJsonString);
        return new Gson().fromJson(jsonElement.getAsJsonObject(), WeatherApiResponse.class);
    }
    
    private String buildApiUrl(String query) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(apiBaseUrl);
        urlBuilder.append("?cnt=1&mode=json&units=metric");
        urlBuilder.append("&appid=").append(apiKey);
        urlBuilder.append("&q=").append(query);
        String url = urlBuilder.toString();
        LOGGER.info("Generated Url = {}", url);
        return url;
    }

   


 /*   @Override
    public List<Weather> test(String cityName, String updatedOn, int weatherId) {
        City city = cityRepository.findCityByName(cityName);
        LOGGER.info("City Entity = {}", city);
        List<Weather> weather1 = weatherRepository.findWeatherByCityID(city);
        LOGGER.info("Weather1 findWeatherByCityID = {}", weather1);
        Weather weather2 = weatherRepository.findWeatherById(weatherId);
        LOGGER.info("Weather2 findWeatherById = {}", weather2);
        List<Weather> weather3 = weatherRepository.findWeatherByUpdatedOn(Instant.parse(updatedOn));
        LOGGER.info("Weather3 findWeatherByUpdatedOn = {}", weather3);
        List<Weather> result = new LinkedList<>();
        result.add(weather2);
        result.addAll(weather1);
        result.addAll(weather3);

        return result;

    }*/
}