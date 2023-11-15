package it.euris.progettocinema.demo.service;


import it.euris.progettocinema.demo.data.model.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> findAll();

    Ticket insert(Ticket ticket);

    Ticket update(Ticket ticket);

    Boolean deleteById(Long id);

    Ticket findById(Long id);

}
