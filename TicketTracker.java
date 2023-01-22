package com.greatlearning.ticketTrackerApplication.model;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.loader.plan.spi.Return;

import java.text.SimpleDateFormat;

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
		
	public TicketTracker(String TicketContent , String TicketTitle, String TicketCreatedOn, String TicketDescription) {
		this.ticketContent = TicketContent;
		this.ticketTitle = TicketTitle;
		this.ticketCreatedOn = TicketCreatedOn;
		this.ticketDescription = TicketDescription;
	}
	
	public TicketTracker() {
		
	}
	
	public int getTicketid() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
	this.ticketId = ticketId; 
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
		return this.ticketCreatedOn ;	
	}
	public void setTicketCreatedOn(String TicketCreatedOn) {
		this.ticketCreatedOn = TicketCreatedOn;
		
	}
	public String getTicketDescription() {
		return this.ticketDescription;		
	}
	public void setTicketDescription(String TicketDescription) {
		this.ticketDescription = TicketDescription;
		
	}

	
}