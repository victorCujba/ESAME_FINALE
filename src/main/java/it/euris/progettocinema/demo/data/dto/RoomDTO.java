package it.euris.progettocinema.demo.data.dto;

import it.euris.progettocinema.demo.data.archetype.Dto;
import it.euris.progettocinema.demo.data.model.Cinema;
import it.euris.progettocinema.demo.data.model.Movie;
import it.euris.progettocinema.demo.data.model.Room;
import it.euris.progettocinema.demo.data.model.Spectator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.stringToInteger;
import static it.euris.progettocinema.demo.utility.DataConversionUtils.stringToLong;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoomDTO implements Dto {

    private String id;
    private String name;
    private String capacity;
    private List<String> idSpectators;
    private String idMovie;
    private String idCinema;

    @Override
    public Room toModel() {
//        List<Spectator> spectatorList = spectatorDTOList.stream()
//                .map(SpectatorDTO::toModel).toList();
        List<Spectator> spectatorList = new ArrayList<>();
        if (idSpectators == null) {
            spectatorList = new ArrayList<>();

        } else {
            for (String idSpc : idSpectators) {
                spectatorList.add(Spectator.builder().idSpectator(stringToLong(idSpc)).build());
            }
        }
        return Room.builder()
                .name(name)
                .capacity(stringToInteger(capacity))
                .spectatorList(spectatorList)
                .movie(Movie.builder().id(stringToLong(idMovie)).build())
                .cinema(Cinema.builder().id(stringToLong(idCinema)).build())
                .build();
    }

    public void emptyRoom() {
        setIdSpectators(new ArrayList<>());
    }
}
