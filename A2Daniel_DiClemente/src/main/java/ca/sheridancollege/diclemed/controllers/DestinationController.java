/* 
 *  Name: Dan Di Clemente
 *  Course: Enterprise Java
 *  Assignment: Assignment 2
 *  Date: October 16, 2020
 */

package ca.sheridancollege.diclemed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.diclemed.beans.Destination;
import ca.sheridancollege.diclemed.repositories.DestinationList;

@Controller
public class DestinationController {

	private DestinationList destinationList;
	
	@Autowired // constructor based dependency injection
	public DestinationController(DestinationList destinationList) {
		this.destinationList = destinationList;
	}
	
	// main page with links to home/add/search/display
	@GetMapping("/")
	public String goHome(Model model) {
		
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", destinationList.getDestinationList());
		return "index";
	}
	
	// page that "add" link directs to
	@GetMapping("/addDestination")
	public String addDestination(Model model) {
		
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", destinationList.getDestinationList());
		return "addDestination";
	}
	
	// form action from /addDestination page
	@PostMapping("/postAddDestination")
	public String postAddDestination(Model model, @ModelAttribute Destination destination) {
		
		destinationList.addDestination(destination);
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", destinationList.getDestinationList());
		return "addDestination"; // return to form to add another entry
	}
	
	// form that "search" link directs to
	@GetMapping("/searchDestination")
	public String searchDestination(Model model) {
		
		model.addAttribute("destination", new Destination());
		return "searchDestination";
	}
	
	@PostMapping("/postSearchDestination")
	public String postSearchDestination(Model model, @RequestParam String year) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("matchList", destinationList.searchDestination(year));
		return "searchDestination"; // return to form to search again
	}
	
	// table displaying all added destinations
	@GetMapping("/displayDestination")
	public String displayDestination(Model model) {
		
		model.addAttribute("destination", new Destination());
		model.addAttribute("destinationList", destinationList.getDestinationList());
		return "displayDestination";
	}
}
