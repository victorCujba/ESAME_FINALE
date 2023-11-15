package it.euris.progettocinema.demo.data.dto;

import it.euris.progettocinema.demo.data.archetype.Dto;
import it.euris.progettocinema.demo.data.model.Room;
import it.euris.progettocinema.demo.data.model.Spectator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String idRoom;

    @Override
    public Spectator toModel() {
        return Spectator.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(stringToLocalDateTime(dateOfBirth))
                .room(Room.builder().id(stringToLong(idRoom)).build())
                .build();
    }
}
