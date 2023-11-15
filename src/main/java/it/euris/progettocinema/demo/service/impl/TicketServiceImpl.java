package it.euris.progettocinema.demo.service.impl;

import it.euris.progettocinema.demo.data.model.Ticket;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.repository.TicketRepository;
import it.euris.progettocinema.demo.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket insert(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        if (ticket.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return ticketRepository.save(ticket);
    }

    @Override
    public Boolean deleteById(Long id) {
        ticketRepository.deleteById(id);
        return ticketRepository.findById(id).isEmpty();
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(Ticket.builder().build());
    }
}
