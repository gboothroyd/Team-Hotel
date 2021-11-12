package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dmacc.repository.HotelRepository;


/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Nov 10, 2021
 */
@Controller
public class WebControllerGary {
@Autowired
HotelRepository repo;

@GetMapping({ "viewAll" })
public String viewAllHotels(Model model) {
model.addAttribute("hotel", repo.findAll());
return "hotelresults";
}

}
