package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Hotel;
import dmacc.repository.HotelRepository;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Nov 10, 2021
 */
@Configuration
public class BeanConfiguration {
	@Autowired
	HotelRepository repo;
	


	@Bean
	public Hotel hotelMarriott() {
		
		Hotel marriott = new Hotel("Marriott", "Monday - Friday", 70.00, "200 sqaure feet");
		repo.save(marriott);
	return marriott;
	}
	
	@Bean
	public Hotel hotelHolidayInn() {
		Hotel holidayInn = new Hotel("Holiday Inn", "Saturday - Sunday", 90.00, "250 square feet" );
		repo.save(holidayInn);
	return holidayInn;
	}
	
	@Bean
	public Hotel hotelComfortInn() {
		Hotel comfortInn = new Hotel("Comfort Inn", "Monday - Wednesday", 65.00, "150 square feet"  );
		repo.save(comfortInn);
	return comfortInn;
	}
	
	@Bean
	public Hotel hotelBaymont() {
		Hotel baymont = new Hotel("Baymont", "Thursday - Sunday", 102.00, "300 square feet"  );
		repo.save(baymont);
	return baymont;
	}
	
	@Bean
	public Hotel hotelRamada() {
		Hotel ramada = new Hotel("Ramada", "Friday - Tuesday", 87.00, "225 square feet" );
		repo.save(ramada);
	return ramada;
	}
	
	@Bean
	public Hotel hotelDaysInn() {
		Hotel daysInn = new Hotel("Days Inn", "Monday - Wednesday", 92.00, "275 square feet" );
		repo.save(daysInn);
	return daysInn;
	}
	
	@Bean
	public Hotel hotelSleepInn() {
		Hotel sleepInn = new Hotel("Sleep Inn", "Thursday - Tuesday", 76.00, "175 square feet" );
		repo.save(sleepInn);
	return sleepInn;
	}

}
