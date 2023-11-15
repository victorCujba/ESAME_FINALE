package it.euris.progettocinema.demo.data.dto;

import it.euris.progettocinema.demo.data.archetype.Dto;
import it.euris.progettocinema.demo.data.model.Cinema;
import it.euris.progettocinema.demo.data.model.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.stringToLong;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CinemaDTO implements Dto {

    private String id;
    private String name;
    private List<String> idRooms;

    @Override
    public Cinema toModel() {

        List<Room> roomList = new ArrayList<>();
        if (idRooms == null) {
            roomList = new ArrayList<>();
        } else {
            for (String id : idRooms) {
                roomList.add(Room.builder().id(stringToLong(id)).build());
            }
        }
//        List<Room> roomList = roomDTOS.stream()
//                .map(RoomDTO::toModel).toList();

        return Cinema.builder()
                .name(name)
                .roomList(roomList)
                .build();
    }
}
