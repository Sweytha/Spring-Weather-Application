package com.bptn.weatherapp.service.impl;


import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.WeatherHistory;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.repository.WeatherHistoryRepository;
import com.bptn.weatherapp.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherHistoryRepository weatherHistoryRepository;
   public List<WeatherHistory> findWeatherByCityID(String city) throws Exception {
	   LOGGER.debug("Finding Weather by City = {}", city);
       City cty = cityRepository.findCityByName(city);
       if (cty == null) {
           throw new Exception("City doesn't exist");
       }
       List<WeatherHistory> weatherHistoryList = weatherHistoryRepository.findWeatherByCityID(cty);
       if (weatherHistoryList == null || weatherHistoryList.isEmpty()) {
           throw new Exception("WeatherHistory doesn't exist");
       }
       return weatherHistoryList;
   }

   @Override
   public List<WeatherHistory> findWeatherByUpdatedOn(String updatedOn) throws Exception {
	   LOGGER.debug("Finding Weather by Updated On = {}", updatedOn);
       List<WeatherHistory> weatherHistoryList =
               weatherHistoryRepository.findWeatherByUpdatedOn(Instant.parse(updatedOn));
       if (weatherHistoryList == null || weatherHistoryList.isEmpty()) {
           throw new Exception("WeatherHistory doesn't exist");
       }
       return weatherHistoryList;
   }

   @Override
   public WeatherHistory findWeatherById(int id) throws Exception {
	   LOGGER.debug("Finding Weather by id = {}", id);
       WeatherHistory weatherHistory = weatherHistoryRepository.findWeatherById(id);
       if (weatherHistory == null) {
           throw new Exception("WeatherHistory doesn't exist");
       }
       return weatherHistory;
   }

   @Override
   public List<WeatherHistory> findWeatherByCreatedOnBetween(String from, String to) throws Exception {
	   LOGGER.debug("Finding Weather from = {} to to = {}", from, to);
       List<WeatherHistory> weatherHistoryList =
               weatherHistoryRepository.findWeatherByCreatedOnBetween(Instant.parse(from), Instant.parse(to));
       if (weatherHistoryList == null || weatherHistoryList.isEmpty()) {
           throw new Exception("WeatherHistory doesn't exist");
       }
       return weatherHistoryList;
   }
}
