package com.greatlearning.ticketTrackerApplication.model;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.loader.plan.spi.Return;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticket_tracker")
@Data
@NoArgsConstructor
public class TicketTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private int ticketId;

	@Column(name = "ticket_title")
	private String ticketTitle;

	@Column(name = "ticket_description")
	private String ticketDescription;

	@Column(name = "ticket_content")
	private String ticketContent;

	@Column(name = "ticket_created_on")
	private String ticketCreatedOn;
		
	public TicketTracker(String TicketContent , String TicketTitle, String TicketCreatedOn) {
		this.ticketContent = TicketContent;
		this.ticketTitle = TicketTitle;
		this.ticketCreatedOn = TicketCreatedOn;
		this.ticketDescription = ticketDescription;
	}
	public String getTicketContent() {
		return ticketContent;
	}
	public void setTicketContent(String TicketContent) {
		this.ticketContent = TicketContent;
	}
	public String getTicketTitle() {
		return ticketContent;
	}
	public void setTicketTitle(String TicketTitle) {
		this.ticketTitle = TicketTitle;
	}
	public String getTicketCreatedOn() {
		this.ticketCreatedOn = TicketCreatedOn;		
	}
	public void setTicketCratedOn(String TicketCreatedOn) {
		this.ticketCreatedOn = TicketCreatedOn;
		
	}
	public String getTicketDescription() {
		this.ticketDescription = TicketDescription;		
	}
	public void setTicketDescription(String TicketDescription) {
		this.ticketDescription = TicketDescription;
		
	}

	
}