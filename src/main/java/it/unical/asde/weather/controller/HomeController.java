package it.unical.asde.weather.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import it.unical.asde.weather.user.User;
import it.unical.asde.weather.utility.ApiDecoder;
import it.unical.asde.weather.utility.JsonReader;
import it.unical.asde.weather.utility.ServerInfo;

@Controller
public class HomeController {

	String message = "Well come to Spring MCV";
	private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	
	
	private User user;
	
	@RequestMapping("/")
	public String showIndex() {
		System.out.println("helloword");
		
		return "index";
	}
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ResponseEntity<String> login(@RequestParam String data, HttpSession sessionObj) {
		System.out.println("in controller");
		String returnJson = "{"
				+ "\"status\":\"done\", "
				+ "\"data\":{\"id\":\"1\",\"name\":\"ciccio\", \"email\":\"ciccio@gmail.com\", \"password\":\"chicco\", \"city\":\"Cosenza\", \"country\":\"Italy\"}"
				+ "}";

		Map<String, Object> map = gson.fromJson(data, new TypeToken<Map<String,Object>>(){}.getType());
		
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>(returnJson, responseHeader, HttpStatus.CREATED);
	}
	
	@RequestMapping("/register")
	public ResponseEntity<String> register(@RequestParam String data) {
		
		System.out.println("in controller");
		
		
		JSONObject jsonObj = new JSONObject(data);
		
		user =new User();
		user.setName(jsonObj.getString("name"));
		System.out.println("USER "+user.getName());
		
		String returnJson = "{\"id\":\"1\",\"name\":\"ciccio\", \"email\":\"ciccio@gmail.com\", \"password\":\"chicco\", \"city\":\"Cosenza\", \"country\":\"Italy\"}";

		Map<String, Object> map = gson.fromJson(data, new TypeToken<Map<String,Object>>(){}.getType());
		
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>(returnJson, responseHeader, HttpStatus.CREATED);
	}
	
	@RequestMapping("/weather")
	public ResponseEntity<String> weather() {
		
		String returnJson = "{\"Status\":\"Error\", \"Data\":\"null\"}";
		ArrayList<String> cities = new ArrayList<String>();
		cities.add("London");
		cities.add("Rome");
		cities.add("Milan");
		cities.add("New York");
		cities.add("Addis Ababa");
		
		JsonReader jr = new JsonReader();
	    JSONObject json= new JSONObject();
	    
		try {
			/*ArrayList<Map<String,Object>> forcastWeek = new ArrayList<Map<String,Object>>();
			
			for(String city:cities){
				json = jr.readJsonFromUrl("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&appid=f803237aaa82cface910b58b8a93942b&units=metric");
				Map<String, Object> map = gson.fromJson(json.toString(), new TypeToken<Map<String,Object>>(){}.getType());
				forcastWeek.add(map);*/
			
			ArrayList<Map<String,Object>> forcastWeek = new ArrayList<Map<String,Object>>();
            
            for(String city:cities){
                json = jr.readJsonFromUrl(ServerInfo.API_URL+city+"&appid="+ServerInfo.API_KEY+"&units=metric");
                Map<String, Object> map = gson.fromJson(json.toString(), new TypeToken<Map<String,Object>>(){}.getType());
                forcastWeek.add(map);
                
            }
            
            
            ApiDecoder ad= new ApiDecoder(json.toString());
            
            
            //System.out.println(gson.toJson(forcastWeek));
            returnJson = "{\"status\":\"done\", \"data\":"+gson.toJson(forcastWeek)+"}";
				
			
			
			
			System.out.println(gson.toJson(forcastWeek));
			returnJson = "{\"status\":\"done\", \"data\":"+gson.toJson(forcastWeek)+"}";
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>(returnJson, responseHeader, HttpStatus.CREATED);
	}

}