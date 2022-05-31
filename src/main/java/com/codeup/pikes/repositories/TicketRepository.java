package com.codeup.pikes.repositories;

import com.codeup.pikes.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
