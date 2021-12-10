package dmacc.controller;

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

import dmacc.beans.Employee;
import dmacc.beans.Guest;
import dmacc.beans.Reservation;
import dmacc.beans.Room;
import dmacc.service.EmployeeService;
import dmacc.service.GuestService;
import dmacc.service.ReservationService;
import dmacc.service.RoomService;

/**
 * @author booth - gboothroyd@dmacc.edu CIS175 - Fall 2021 Nov 10, 2021
 */
@Controller
public class WebControllerGary {
	
	@Autowired
	private ReservationService resService;
	@Autowired
	private GuestService guestService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private EmployeeService employeeService;
	
	
    @GetMapping("/guestServiceSignIn")
    public String viewGuestServiceSignInPage(Model model) {
    	return "guestservicesignin";
    }
    
    @GetMapping("/hotelManagementSignIn")
    public String viewHotelManagementSignInPage(Model model) {
    	return "hotelmanagementsignin";
    }
    
    @GetMapping("/guestServicePage")
    public String viewHomePage(Model model) {
    	return findPaginated(1, "guest", "asc", model);
    }
    
    @GetMapping("/hotelManagementPage")
    public String viewHotelManagementPage(Model model) {
    	return findPaginated(1, "guest", "asc", model);
     }
    
	@GetMapping("/newReservation")
	public String newReservation(Model model) {
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		List<Room> listroom = roomService.getAllRooms();
		model.addAttribute("listroom", listroom);
		model.addAttribute("room", new Room());
		return "newreservation";
	}
	
	@PostMapping("/saveReservation")
	public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
		resService.saveReservation(reservation);
		return "redirect:/guestServicePage";
	}
	
	@GetMapping("/editReservation/{id}")
	public String editReservationById(@PathVariable ( value = "id") long id, Model model) {
		Reservation reservation = resService.getReservationById(id);
		model.addAttribute("reservation", reservation);
		List<Room> listroom = roomService.getAllRooms();
		model.addAttribute("listroom", listroom);
		model.addAttribute("room", new Room());
		return "editreservation";
	}
	
	@GetMapping("/deleteReservation/{id}")
	public String deleteReservationById(@PathVariable (value = "id") long id) {
		this.resService.deleteReservationById(id);
		return "redirect:/guestServicePage";
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

	@GetMapping("/guestServicePage/{pageNo}")
	public String findGuestPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 500;// Changed to avoid conflicts with DataTables - DT
		
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
		int pageSize = 500;// Changed to avoid conflicts with DataTables - DT
		
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

    @GetMapping("/viewRooms")
    public String viewRoomHomePage(Model model) {
    	return findRoomPaginated(1, "roomNum", "asc", model);
    }
    
	@GetMapping("/newRoom")
	public String newRoom(Model model) {
		Room room = new Room();
		model.addAttribute("room", room);
		return "newroom";
	}
    
	@GetMapping("/editRoom/{roomNum}")
	public String editRoomById(@PathVariable ( value = "roomNum") long roomNum, Model model) {
		Room room = roomService.getRoomById(roomNum);
		model.addAttribute("room", room);
		return "editroompage";
	}
	
	@PostMapping("/saveRoom")
	public String saveRoom(@ModelAttribute("room") Room room) {
		roomService.saveRoom(room);
		return "redirect:/viewRooms";
	}
	
	@GetMapping("/deleteRoom/{roomNum}")
	public String deleteRoomById(@PathVariable (value = "roomNum") long roomNum) {
		this.roomService.deleteRoomById(roomNum);
		return "redirect:/viewRooms";
	}

	@GetMapping("/roomPage/{pageNo}")
	public String findRoomPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 500;// Changed to avoid conflicts with DataTables - DT
		
		Page<Room> page = roomService.findRoomPaginated(pageNo, pageSize, sortField, sortDir);
		List<Room> listRooms = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listRooms", listRooms);
		return "roomhomepage";
	}
	
	@GetMapping("/employeePage/{pageNo}")
	public String findEmployeePaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,Model model) {
		int pageSize = 500;
		
		Page<Employee> page = employeeService.findEmployeePaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listEmployees", listEmployees);
		return "employeehomepage";
		}
	
	  @GetMapping("/viewEmployees")
	  public String viewEmployeeHomePage(Model model) {
		  return findEmployeePaginated(1, "name", "asc", model);
	    }
	  
	  @GetMapping("/newEmployee")
	  public String newEmployee(Model model) {
			Employee employee = new Employee();
			model.addAttribute("employee", employee);
			return "newemployee";
		}

	  @PostMapping("/saveEmployee")
		public String saveEmployee(@ModelAttribute("employee") Employee employee) {
			employeeService.saveEmployee(employee);
			return "redirect:/viewEmployees";
		}
		
	  @GetMapping("/editEmployee/{id}")
		public String editEmployeeById(@PathVariable ( value = "id") long id, Model model) {
			Employee employee = employeeService.getEmployeeById(id);
			model.addAttribute("employee", employee);
			return "editemployee";
		}
		
	  @GetMapping("/deleteEmployee/{id}")
		public String deleteEmployeeById(@PathVariable (value = "id") long id) {
			this.employeeService.deleteEmployeeById(id);
			return "redirect:/viewEmployees";
		}

}