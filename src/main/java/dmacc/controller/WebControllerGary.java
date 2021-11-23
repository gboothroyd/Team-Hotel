package dmacc.controller;

import java.util.ArrayList;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.Guest;
import dmacc.beans.Reservation;
import dmacc.service.GuestService;
//import dmacc.beans.Room;
//import dmacc.repository.GuestRepository;
//import dmacc.repository.ReservationRepository;
//import dmacc.repository.RoomRepository;
import dmacc.service.ReservationService;

/**
 * @author booth - gboothroyd@dmacc.edu CIS175 - Fall 2021 Nov 10, 2021
 */
@Controller
public class WebControllerGary {
	
	@Autowired
	private ReservationService resService;
	@Autowired
	private GuestService guestService;
	
    @GetMapping("/")
    public String viewHomePage(Model model) {
    	return findPaginated(1, "guest", "asc", model);
    }
    
	@GetMapping("/newReservation")
	public String newReservation(Model model) {
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		return "newreservation";
	}
	
	@PostMapping("/saveReservation")
	public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
		resService.saveReservation(reservation);
		return "redirect:/";
	}
	
	@GetMapping("/editReservation/{id}")
	public String editReservationById(@PathVariable ( value = "id") long id, Model model) {
		Reservation reservation = resService.getReservationById(id);
		model.addAttribute("reservation", reservation);
		return "editreservation";
	}
	
	@GetMapping("/deleteReservation/{id}")
	public String deleteReservationById(@PathVariable (value = "id") long id) {
		this.resService.deleteReservationById(id);
		return "redirect:/";
	}
	
	
    @GetMapping("/viewGuests")
    public String viewGuestHomePage(Model model) {
    	return findGuestPaginated(1, "lName", "asc", model);
    }
    
	@GetMapping("/editGuest/{id}")
	public String editGuestById(@PathVariable ( value = "id") long id, Model model) {
		Guest guest = guestService.getGuestById(id);
		model.addAttribute("guest", guest);
		return "editguest";
	}
	
	@PostMapping("/saveGuest")
	public String saveGuest(@ModelAttribute("guest") Guest guest) {
		guestService.saveGuest(guest);
		return "redirect:/viewGuests";
	}
	
	@GetMapping("/deleteGuest/{id}")
	public String deleteGuestById(@PathVariable (value = "id") long id) {
		this.guestService.deleteGuestById(id);
		return "redirect:/viewGuests";
	}

	@GetMapping("/guestPage/{pageNo}")
	public String findGuestPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Guest> page = guestService.findGuestPaginated(pageNo, pageSize, sortField, sortDir);
		List<Guest> listGuests = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listGuests", listGuests);
		return "guesthomepage";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Reservation> page = resService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Reservation> listReservations = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listReservations", listReservations);
		return "homepage";
	}
		
	
	/*
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
*/

}