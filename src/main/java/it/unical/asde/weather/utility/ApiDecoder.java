package it.unical.asde.weather.utility;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiDecoder {
private JSONObject city;
private JSONArray list;
private String raw_data;
private List<ForcastDecoder> forcastList;
 
 public ApiDecoder(String raw_data) {
	 this.raw_data=raw_data;
	 try {
	   decoder(raw_data);	
	 }
	 catch (Exception e) {
		 System.out.println("Decoder Class Exception:"+ e);
	 }
	 }
  public void decoder(String raw_data) {
	  try {
		  JSONObject data= new JSONObject(raw_data);
          city =data.getJSONObject("city");
          list =data.getJSONArray("list");
            ForcastDecoder forcastDecoder;
           for (int i=0;i<=list.length();i++) {        	   
        	   
               forcastDecoder=new ForcastDecoder(list.getJSONObject(i));
               forcastList.add(forcastDecoder);  
           }
           
	         // forcastList.add(arg0)
	        
	     } catch (JSONException e) {
	    	 System.out.println("api decoder" +e);
	         throw new RuntimeException(e);
	     }	 
	  
	  
  }
   private void  decodeCity(JSONObject city) {
	  String id =city.getString("ID");
	  String name=city.getString("name");
	  String country=city.getString("country");
	  int population =city.getInt("population");
	  JSONObject coordinates=city.getJSONObject("coord");
	   
   }
   private void decodeList(JSONArray list) {
             for(int i=0;i<=list.length();i++) {
          // List<Date> date= 
       }
   }


}
