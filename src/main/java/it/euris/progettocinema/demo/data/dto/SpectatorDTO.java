package it.euris.progettocinema.demo.data.dto;

import it.euris.progettocinema.demo.data.archetype.Dto;
import it.euris.progettocinema.demo.data.model.Room;
import it.euris.progettocinema.demo.data.model.Spectator;
import it.euris.progettocinema.demo.data.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.stringToLocalDateTime;
import static it.euris.progettocinema.demo.utility.DataConversionUtils.stringToLong;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SpectatorDTO implements Dto {

    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private List<String> idTickets;

    @Override
    public Spectator toModel() {

        List<Ticket> ticketList = new ArrayList<>();

        if (idTickets == null) {
            ticketList = new ArrayList<>();
        } else {
            for (String id : idTickets) {
                ticketList.add(Ticket.builder().id(stringToLong(id)).build());
            }
        }


        return Spectator.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(stringToLocalDateTime(dateOfBirth))
                .ticketList(ticketList)
                .build();
    }
}
