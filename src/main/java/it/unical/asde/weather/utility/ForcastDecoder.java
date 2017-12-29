package it.unical.asde.weather.utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class ForcastDecoder {

	private String Date_Time;
	private JSONObject rain ;
	private JSONObject snow;
	private JSONArray weather;
	private JSONObject main;
	private JSONObject clouds;
	private JSONObject sys;
	private JSONObject wind;
	private JSONObject list;
	
	public ForcastDecoder(JSONObject list) {		
		this.list = list;		
		System.out.println("api forcast decoder" +list.length()); 
		System.out.println("api forcast decoder" +list.getString("dt_txt")); 
		System.out.println(list.getJSONObject("main"));
		System.out.println(list.getJSONArray("weather"));
	}
	public String getDate_Time() {
		return Date_Time;
	}

	public void setDate_Time() {
		this.Date_Time = list.getString("dt_txt");
	}

	public JSONObject getRain() {
		return rain;
	}

	public void setRain() {
		this.rain = list.getJSONObject("rain");
	}

	public JSONObject getSnow() {
		return snow;
	}

	public void setSnow() {
		this.snow = list.getJSONObject("snow");
	}

	public JSONArray getWeather() {
		return weather;
	}

	public void setWeather() {
		this.weather = this.list.getJSONArray("weather");
	}

	public JSONObject getMain() {
		return main;
	}

	public void setMain() {
		this.main = list.getJSONObject("main");
	}

	public JSONObject getClouds() {
		return clouds;
	}

	public void setClouds() {
		this.clouds = list.getJSONObject("clouds");
	}

	public JSONObject getSys() {
		return sys;
	}

	public void setSys() {
		this.sys = list.getJSONObject("sys");
	}

	public JSONObject getWind() {
		return wind;
	}

	public void setWind() {
		this.wind = list.getJSONObject("wind");
	}
	
}
