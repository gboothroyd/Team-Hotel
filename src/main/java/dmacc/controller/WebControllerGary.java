package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import dmacc.beans.Reservation;
import dmacc.beans.Room;
import dmacc.repository.GuestRepository;
import dmacc.repository.ReservationRepository;
import dmacc.repository.RoomRepository;

/**
 * @author booth - gboothroyd@dmacc.edu CIS175 - Fall 2021 Nov 10, 2021
 */
@Controller
public class WebControllerGary {
	@Autowired
	RoomRepository repo;
	

	@GetMapping({ "viewAll" })
	public String viewAllRooms(Model model) {
		model.addAttribute("room", repo.findAll());
		return "roomresults";
	}
	
	// Guests
	@Autowired
	GuestRepository guestrepo;
	@GetMapping({ "viewAllGuests" })
	public String viewAllGuests(Model model) {
		model.addAttribute("guest", guestrepo.findAll());
		return "guestresults";
	}
	
	// Reservations
	@Autowired
	ReservationRepository reservedrepo;
	@GetMapping({ "viewAllReservations" })
	public String viewAllReservations(Model model) {
		model.addAttribute("reservation", reservedrepo.findAll());
		return "reservationresults";
	}
	
	@GetMapping("/deleteReservation/{id}")
	public String deleteReservation(@PathVariable("id") long id, Model model) {
		Reservation r = reservedrepo.findById(id).orElse(null);
		reservedrepo.delete(r);
	    return viewAllReservations(model);
	}
	
	
	@GetMapping("/getReservation/{id}")
	public String getReservation(@PathVariable("id") long id, Model model) {
		model.addAttribute(reservedrepo.findReservationByGuestId(id));
	    return "guestreservation";
	}
	
	@GetMapping("/editRoom/{id}")
	public String showUpdateRoom(@PathVariable("id") long id, Model model) {
	Room r = repo.findById(id).orElse(null);
	model.addAttribute("newRoom", r);
	return "EditRoom";
	}
	
	@PostMapping("/updateRoom/{id}")
	public String revisePhone(Room r, Model model) {
	repo.save(r);
	return viewAllRooms(model);
	}
	
	@GetMapping("/editReservation/{id}")
	public String showUpdateReservation(@PathVariable("id") long id, Model model) {
	Reservation r = reservedrepo.findById(id).orElse(null);
	model.addAttribute("newReservation", r);
	return "editReservations";
	}
	
	@PostMapping("/updateReservation/{id}")
	public String reviseReservation(Reservation r, Model model) {
	reservedrepo.save(r);
	return viewAllReservations(model);
	}


}