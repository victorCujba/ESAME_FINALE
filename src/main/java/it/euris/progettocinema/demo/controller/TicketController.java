package it.euris.progettocinema.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.progettocinema.demo.data.dto.SpectatorDTO;
import it.euris.progettocinema.demo.data.dto.TicketDTO;
import it.euris.progettocinema.demo.data.model.Spectator;
import it.euris.progettocinema.demo.data.model.Ticket;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.service.SpectatorService;
import it.euris.progettocinema.demo.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tickets")
public class TicketController {


    private TicketService ticketService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all Tickets from the database.
            """)
    public List<TicketDTO> getAllTickets() {
        return ticketService.findAll().stream().map(Ticket::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Room to data base.
            """)
    public TicketDTO insertTicket(@RequestBody TicketDTO ticketDTO) {
        Ticket ticket = ticketDTO.toModel();
        return ticketService.insert(ticket).toDto();
    }


    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update existing Spectator in data base.
            """)
    public TicketDTO updateTicket(@RequestBody TicketDTO ticketDTO) {
        try {
            Ticket ticket = ticketDTO.toModel();
            return ticketService.update(ticket).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
