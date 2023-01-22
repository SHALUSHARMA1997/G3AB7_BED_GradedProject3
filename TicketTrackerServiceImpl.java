package com.greatlearning.ticketTrackerApplication.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.greatlearning.ticketTrackerApplication.model.TicketTracker;
import com.greatlearning.ticketTrackerApplication.service.TicketTrackerService;
import com.greatlearning.ticketTrackerApplication.repository.TicketTrackerRepository;

@Service
public class TicketTrackerServiceImpl implements TicketTrackerService {

	@Autowired
	TicketTrackerRepository ticketTrackerRepository;

	@Override
	public List<TicketTracker> getAllTickets() {
		return ticketTrackerRepository.findAll();
	}

	@Override
	public void saveOrUpdate(TicketTracker ticket) {
		ticketTrackerRepository.save(ticket);
	}

	@Override
	public void deleteTicketById(int id) {
		ticketTrackerRepository.deleteById(id);
	}

	@Override
	public TicketTracker getTicketById(int id) {
		return ticketTrackerRepository.findById(id).get();
	}

	@Override
	public List<TicketTracker> searchTickets(String searchedKeyword) {
		return ticketTrackerRepository.findByKeyword(searchedKeyword);
	}

}
