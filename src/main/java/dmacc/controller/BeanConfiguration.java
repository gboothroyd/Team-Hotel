package dmacc.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Employee;
import dmacc.beans.Guest;
import dmacc.beans.Reservation;
import dmacc.beans.Room;
import dmacc.repository.EmployeeRepository;
import dmacc.repository.GuestRepository;
import dmacc.repository.ReservationRepository;
import dmacc.repository.RoomRepository;

/**
 * @author booth - gboothroyd@dmacc.edu CIS175 - Fall 2021 Nov 10, 2021
 */
@Configuration
public class BeanConfiguration {
	@Autowired
	RoomRepository repo;
	@Autowired
	EmployeeRepository eRepo;


	@Bean
	public Room room100() {

		Room room100 = new Room("100", "Monday - Friday", 70.00, "200 square feet");
		repo.save(room100);
		return room100;
	}

	@Bean
	public Room room101() {
		Room room101 = new Room("101", "Saturday - Sunday", 90.00, "250 square feet");
		repo.save(room101);
		return room101;
	}

	@Bean
	public Room room102() {
		Room room102 = new Room("102", "Monday - Wednesday", 65.00, "150 square feet");
		repo.save(room102);
		return room102;
	}

	@Bean
	public Room room103() {
		Room room103 = new Room("103", "Thursday - Sunday", 102.00, "300 square feet");
		repo.save(room103);
		return room103;
	}

	@Bean
	public Room room104() {
		Room room104 = new Room("104", "Friday - Tuesday", 87.00, "225 square feet");
		repo.save(room104);
		return room104;
	}

	@Bean
	public Room room105() {
		Room room105 = new Room("105", "Monday - Wednesday", 92.00, "275 square feet");
		repo.save(room105);
		return room105;
	}

	@Bean
	public Room room106() {
		Room room106 = new Room("106", "Thursday - Tuesday", 76.00, "175 square feet");
		repo.save(room106);
		return room106;
	}
	
	@Bean
	public Employee brad() {
		Employee brad = new Employee("Brad Wellington", 2400.00, 22);
		eRepo.save(brad);
		return brad;
	}
	
	@Bean
	public Employee jeff() {
		Employee jeff = new Employee("Jeff Bezos", 2000.00, 21);
		eRepo.save(jeff);
		return jeff;
	}
	
	@Bean
	public Employee harold() {
		Employee harold = new Employee("Harold Johnson", 3500.00, 25);
		eRepo.save(harold);
		return harold;
	}
	
	@Bean
	public Employee deme() {
		Employee deme = new Employee("Deme Olson", 4000.00, 20);
		eRepo.save(deme);
		return deme;
	}
	
	@Bean
	public Employee jessica() {
		Employee jessica = new Employee("Jessica White", 2500.00, 28);
		eRepo.save(jessica);
		return jessica;
	}
	
	
	// Guests 
	@Autowired
	GuestRepository guestrepo;
	
	@Bean
	public Guest morty() {
		Guest morty = new Guest("Morty", "Smith", "111-222-3333", "VISA");
		guestrepo.save(morty);
		return morty;
	}
	
	
	// Reservations 
	@Autowired
	ReservationRepository reservedrepo;
	
	
	//@Bean
	//public Reservation mortyRes() {
		//Guest rick = new Guest("Rick", "Smith", "333-222-1111", "VISA");
		//Room room200 = new Room("200", "Monday - Friday", 70.00, "200 sqaure feet");
		
		
		//LocalDate start = LocalDate.now();
		//LocalDate end = start.plusDays(10);
		
		//String start = "12-01-2021";
		//String end = "12-02-2021";
		
		//Reservation rickRes = new Reservation(rick, room200, start, end, 2);
		//reservedrepo.save(rickRes);
		//return rickRes;
	//}
	

}