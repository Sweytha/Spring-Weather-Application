package com.bptn.weatherapp.response;

import java.util.ArrayList;

public class ListResponse {

	  private Double dt;
	   private Double sunrise;
	   private Double sunset;
	   TempResponse temp;
	   FeelsLikeResponse feels_like;
	   private Double pressure;
	   private Double humidity;
	   ArrayList<WeatherResponse> weather = new ArrayList<>();
	   private Double speed;
	   private Double deg;
	   private Double gust;
	   private Double clouds;
	   private Double pop;
	   private Double rain;
	   
	   
	public Double getDt() {
		return dt;
	}
	public void setDt(Double dt) {
		this.dt = dt;
	}
	public Double getSunrise() {
		return sunrise;
	}
	public void setSunrise(Double sunrise) {
		this.sunrise = sunrise;
	}
	public Double getSunset() {
		return sunset;
	}
	public void setSunset(Double sunset) {
		this.sunset = sunset;
	}
	public TempResponse getTemp() {
		return temp;
	}
	public void setTemp(TempResponse temp) {
		this.temp = temp;
	}
	public FeelsLikeResponse getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(FeelsLikeResponse feels_like) {
		this.feels_like = feels_like;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	public ArrayList<WeatherResponse> getWeather() {
		return weather;
	}
	public void setWeather(ArrayList<WeatherResponse> weather) {
		this.weather = weather;
	}
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Double getDeg() {
		return deg;
	}
	public void setDeg(Double deg) {
		this.deg = deg;
	}
	public Double getGust() {
		return gust;
	}
	public void setGust(Double gust) {
		this.gust = gust;
	}
	public Double getClouds() {
		return clouds;
	}
	public void setClouds(Double clouds) {
		this.clouds = clouds;
	}
	public Double getPop() {
		return pop;
	}
	public void setPop(Double pop) {
		this.pop = pop;
	}
	public Double getRain() {
		return rain;
	}
	public void setRain(Double rain) {
		this.rain = rain;
	}
	   
	   
}
