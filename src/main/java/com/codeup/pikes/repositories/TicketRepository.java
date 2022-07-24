package com.codeup.pikes.repositories;

import com.codeup.pikes.models.Business;
import com.codeup.pikes.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT * FROM tickets t WHERE t.ticket_num LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<Ticket> searchTickets(Long search);

}
