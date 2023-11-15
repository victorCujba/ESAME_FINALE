package it.euris.progettocinema.demo.repository;

import it.euris.progettocinema.demo.data.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
