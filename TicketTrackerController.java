package com.greatlearning.ticketTrackerApplication.controller;

import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import com.greatlearning.ticketTrackerApplication.model.TicketTracker;
import com.greatlearning.ticketTrackerApplication.service.TicketTrackerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TicketTrackerController {

	@Autowired
	TicketTrackerService ticketTrackerService;

	@GetMapping(path = { "/", "/ticket/search" })
	public String getAllTickets(Model ticketTrackerModel, String searchKeyword) {
		if (searchKeyword != null) {
			List<TicketTracker> allTickets = ticketTrackerService.searchTickets(searchKeyword);
			ticketTrackerModel.addAttribute("ticketTracker", allTickets);
			ticketTrackerModel.addAttribute("searchKeyword", searchKeyword);
		} else {
			List<TicketTracker> allTickets = ticketTrackerService.getAllTickets();
			ticketTrackerModel.addAttribute("ticketTracker", allTickets);
		}
		return "ticket_tracker_home_page";
	}

	@GetMapping("/reset")
	public String resetHomePage() {
		return "redirect:/";
	}

	@GetMapping("/create/ticket")
	public String createNewTicket(Model ticketTrackerModel) {
		TicketTracker tt = new TicketTracker();
		ticketTrackerModel.addAttribute("ticketTracker", tt);
		return "create_ticket";
	}

	@GetMapping("/ticket/edit/{id}")
	public String editTicket(Model ticketTrackerModel, @PathVariable("id") int id) {
		TicketTracker ticketTracker = ticketTrackerService.getTicketById(id);
		ticketTrackerModel.addAttribute("ticketTracker", ticketTracker);
		return "edit_ticket";
	}

	@GetMapping("/ticket/delete/{id}")
	public String deleteTicket(@PathVariable("id") int id) {
		ticketTrackerService.deleteTicketById(id);
		//log.info("Ticket deleted!!!");
		return "redirect:/";
	}

	@GetMapping("/ticket/view/{id}")
	public String getTicketView(Model ticketTrackerModel, @PathVariable("id") int id) {
		TicketTracker tt = ticketTrackerService.getTicketById(id);
		ticketTrackerModel.addAttribute("ticketTracker", tt);
		return "view_ticket";
	}

	@PostMapping("/save/ticket")
	public String saveTicket(@ModelAttribute("ticketTracker") TicketTracker tt) {
		tt.setTicketCreatedOn(new String(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MM yyyy"))));
		ticketTrackerService.saveOrUpdate(tt);
		//log.info("Ticket saved successfully!!!");
		return "redirect:/";
	}

	@PostMapping("/edit/ticket/{id}")
	public String editTicket(@ModelAttribute("ticketTracker") TicketTracker tt, @PathVariable("id") int id) {
		TicketTracker ticketTracker = ticketTrackerService.getTicketById(id);
		ticketTracker.setTicketContent(tt.getTicketContent());
		ticketTracker.setTicketCreatedOn(new String(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MM yyyy"))));
		ticketTracker.setTicketDescription(tt.getTicketDescription());
		ticketTracker.setTicketTitle(tt.getTicketTitle());
		ticketTrackerService.saveOrUpdate(ticketTracker);
		//log.info("Ticket edited successfully!!!");
		return "redirect:/";
	}
}
