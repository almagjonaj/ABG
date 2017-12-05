package test;

import com.abg.model.City;
import com.abg.model.Destination;

public class Test {
	
	public static void main(String[] args) {
		Destination destination = new Destination();
		
		City city = new City();
		
		city.setCity_name("Kico");
		
		city.setIdcity(5);
		
		destination.setCity(city);
		
		System.out.println(destination.getCity().getCity_name());
	}

}
