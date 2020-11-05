package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import dmacc.beans.Ticket;
import dmacc.repository.TicketRepository;

@Controller
public class WebController {
	@Autowired
	TicketRepository repo;

	@GetMapping("/viewAll")
	public String viewAllTickets(Model model) {
		model.addAttribute("tickets", repo.findAll());
		return "results";
	}

	@GetMapping("/inputTicket")
	public String addNewTicket(Model model) {
		Ticket c = new Ticket();
		model.addAttribute("newTicket", c);
		return "input";
	}

	@PostMapping("/inputTicket")
	public String addNewTicket(@ModelAttribute Ticket c, Model model) {
		repo.save(c);
		return viewAllTickets(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateTicket(@PathVariable("id") long id, Model model) {
		Ticket c = repo.findById(id).orElse(null);
		model.addAttribute("newTicket", c);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseTicket(Ticket c, Model model) {
		repo.save(c);
		return viewAllTickets(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable("id") long id, Model model) {
		Ticket c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllTickets(model);
	}
}