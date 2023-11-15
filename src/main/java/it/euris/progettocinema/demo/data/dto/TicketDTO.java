package it.euris.progettocinema.demo.data.dto;

import it.euris.progettocinema.demo.data.archetype.Dto;
import it.euris.progettocinema.demo.data.model.Movie;
import it.euris.progettocinema.demo.data.model.Room;
import it.euris.progettocinema.demo.data.model.Spectator;
import it.euris.progettocinema.demo.data.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.stringToInteger;
import static it.euris.progettocinema.demo.utility.DataConversionUtils.stringToLong;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TicketDTO implements Dto {

    private String id;
    private String position;
    private String price;
    private String idSpectator;
    private String idMovie;

    @Override
    public Ticket toModel() {
        return Ticket.builder()
                .position(position)
                .price(stringToInteger(price))
                .spectator(Spectator.builder().idSpectator(stringToLong(idSpectator)).build())
                .movie(Movie.builder().id(stringToLong(idMovie)).build())
                .build();
    }


}
