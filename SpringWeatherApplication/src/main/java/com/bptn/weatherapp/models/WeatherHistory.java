package com.bptn.weatherapp.models;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"WeatherHistory\"")
public class WeatherHistory {
	@Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @Column(name = "sunrise")
    private Instant sunrise;

    @Column(name = "sunset")
    private Instant sunset;

    @Column(name = "\"tempMin\"")
    private BigDecimal tempMin;

    @Column(name = "\"tempMax\"")
    private BigDecimal tempMax;

    @Column(name = "\"tempDay\"")
    private BigDecimal tempDay;

    @Column(name = "\"tempNight\"")
    private BigDecimal tempNight;

    @Column(name = "\"tempMorning\"")
    private BigDecimal tempMorning;

    @Column(name = "\"tempEvening\"")
    private BigDecimal tempEvening;

    @Column(name = "\"feelsLikeDay\"")
    private BigDecimal feelsLikeDay;

    @Column(name = "\"feelsLikeNight\"")
    private BigDecimal feelsLikeNight;

    @Column(name = "\"feelsLikeMorning\"")
    private BigDecimal feelsLikeMorning;

    @Column(name = "\"feelsLikeEvening\"")
    private BigDecimal feelsLikeEvening;

    @Column(name = "precipitation")
    private BigDecimal precipitation;

    @Column(name = "\"windSpeed\"")
    private BigDecimal windSpeed;

    @Column(name = "\"windDirection\"")
    private BigDecimal windDirection;

    @Column(name = "\"windGust\"")
    private BigDecimal windGust;

    @Column(name = "pressure")
    private BigDecimal pressure;

    @Column(name = "humidity")
    private BigDecimal humidity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"cityID\"", nullable = false)
    private City cityID;

    @Column(name = "\"updatedOn\"")
    private Instant updatedOn;

    @Column(name = "\"createdOn\"")
    private Instant createdOn;
    
    

	public WeatherHistory() {
		super();
	}

	public WeatherHistory(Integer id, String name, String description, String icon, Instant sunrise, Instant sunset,
			BigDecimal tempMin, BigDecimal tempMax, BigDecimal tempDay, BigDecimal tempNight, BigDecimal tempMorning,
			BigDecimal tempEvening, BigDecimal feelsLikeDay, BigDecimal feelsLikeNight, BigDecimal feelsLikeMorning,
			BigDecimal feelsLikeEvening, BigDecimal precipitation, BigDecimal windSpeed, BigDecimal windDirection,
			BigDecimal windGust, BigDecimal pressure, BigDecimal humidity, City cityID, Instant updatedOn,
			Instant createdOn) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.tempDay = tempDay;
		this.tempNight = tempNight;
		this.tempMorning = tempMorning;
		this.tempEvening = tempEvening;
		this.feelsLikeDay = feelsLikeDay;
		this.feelsLikeNight = feelsLikeNight;
		this.feelsLikeMorning = feelsLikeMorning;
		this.feelsLikeEvening = feelsLikeEvening;
		this.precipitation = precipitation;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.windGust = windGust;
		this.pressure = pressure;
		this.humidity = humidity;
		this.cityID = cityID;
		this.updatedOn = updatedOn;
		this.createdOn = createdOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Instant getSunrise() {
		return sunrise;
	}

	public void setSunrise(Instant sunrise) {
		this.sunrise = sunrise;
	}

	public Instant getSunset() {
		return sunset;
	}

	public void setSunset(Instant sunset) {
		this.sunset = sunset;
	}

	public BigDecimal getTempMin() {
		return tempMin;
	}

	public void setTempMin(BigDecimal tempMin) {
		this.tempMin = tempMin;
	}

	public BigDecimal getTempMax() {
		return tempMax;
	}

	public void setTempMax(BigDecimal tempMax) {
		this.tempMax = tempMax;
	}

	public BigDecimal getTempDay() {
		return tempDay;
	}

	public void setTempDay(BigDecimal tempDay) {
		this.tempDay = tempDay;
	}

	public BigDecimal getTempNight() {
		return tempNight;
	}

	public void setTempNight(BigDecimal tempNight) {
		this.tempNight = tempNight;
	}

	public BigDecimal getTempMorning() {
		return tempMorning;
	}

	public void setTempMorning(BigDecimal tempMorning) {
		this.tempMorning = tempMorning;
	}

	public BigDecimal getTempEvening() {
		return tempEvening;
	}

	public void setTempEvening(BigDecimal tempEvening) {
		this.tempEvening = tempEvening;
	}

	public BigDecimal getFeelsLikeDay() {
		return feelsLikeDay;
	}

	public void setFeelsLikeDay(BigDecimal feelsLikeDay) {
		this.feelsLikeDay = feelsLikeDay;
	}

	public BigDecimal getFeelsLikeNight() {
		return feelsLikeNight;
	}

	public void setFeelsLikeNight(BigDecimal feelsLikeNight) {
		this.feelsLikeNight = feelsLikeNight;
	}

	public BigDecimal getFeelsLikeMorning() {
		return feelsLikeMorning;
	}

	public void setFeelsLikeMorning(BigDecimal feelsLikeMorning) {
		this.feelsLikeMorning = feelsLikeMorning;
	}

	public BigDecimal getFeelsLikeEvening() {
		return feelsLikeEvening;
	}

	public void setFeelsLikeEvening(BigDecimal feelsLikeEvening) {
		this.feelsLikeEvening = feelsLikeEvening;
	}

	public BigDecimal getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(BigDecimal precipitation) {
		this.precipitation = precipitation;
	}

	public BigDecimal getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}

	public BigDecimal getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(BigDecimal windDirection) {
		this.windDirection = windDirection;
	}

	public BigDecimal getWindGust() {
		return windGust;
	}

	public void setWindGust(BigDecimal windGust) {
		this.windGust = windGust;
	}

	public BigDecimal getPressure() {
		return pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public City getCityID() {
		return cityID;
	}

	public void setCityID(City cityID) {
		this.cityID = cityID;
	}

	public Instant getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Instant updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Instant getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}
    
    

}
