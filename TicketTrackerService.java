package com.greatlearning.ticketTrackerApplication.service;

import java.util.List;

import com.greatlearning.ticketTrackerApplication.model.TicketTracker;

public interface TicketTrackerService {

	public List<TicketTracker> getAllTickets();

	public void saveOrUpdate(TicketTracker ticket);

	public void deleteTicketById(int id);

	public TicketTracker getTicketById(int id);

	public List<TicketTracker> searchTickets(String searchedKeyword);
}
