package com.greatlearning.ticketTrackerApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatlearning.ticketTrackerApplication.model.TicketTracker;

@Repository
public interface TicketTrackerRepository extends JpaRepository<TicketTracker, Integer> {

	@Query(value = "select * from ticket_tracker tt where tt.ticket_title like %:keyword% or tt.ticket_description like %:keyword%", nativeQuery = true)
	List<TicketTracker> findByKeyword(@Param("keyword") String keyword);
}
