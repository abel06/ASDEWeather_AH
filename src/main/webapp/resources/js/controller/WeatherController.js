/**
 * 
 */
App.controller("WeatherController", function WeatherController($scope){
		
	$scope.query = {city:""};
	
	$scope.weatherData = [];
	$scope.search = function search(){
	}
	
	$scope.loadSelectedCity = function loadSelectedCity(){
		
		$.ajax({
	    	type:'GET',
	    	url:"/ASDEWeatherApp/weather", 
	    	
	    	success:function(response,status){
	    		if(response.status=="done"){
	    			console.log(response.data);

	    			$scope.setData(response.data);
	    			
	    		}
	    		else{
	    			console.log(response.data);
	    		}
	    	}	    	
	    });
		
	}
	
	$scope.setData = function(input){
		for(var i=0; i< input.length; i++ ){
			$scope.weatherData.push({name:input[i]["city"]["name"],
							temp:input[i]["list"][0]["main"]["temp"],
							maxTemp:input[i]["list"][0]["main"]["temp_min"],
							humidity:input[i]["list"][0]["main"]["humidity"]});
			console.log(input[i]["list"][0]["main"]["temp_min"]);
			//console.log(input[i][3][0]["main"]["temp"]);
//			for(var j=0; j< input[i]["list"]["main"].length; j++ )
//				{
//				console.log(input[i]["list"][j]["main"])
//				}
		
		}
		console.log($scope.weatherData)
	$scope.$apply();
	
	}
});