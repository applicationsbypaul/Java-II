package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.Ticket;

@Repository
public interface TicketRepository extends
JpaRepository<Ticket, Long> { }
