package it.euris.progettocinema.demo.data.model;

import it.euris.progettocinema.demo.data.archetype.Model;
import it.euris.progettocinema.demo.data.dto.CinemaDTO;
import it.euris.progettocinema.demo.data.dto.RoomDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.numberToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "cinema")
public class Cinema implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.MERGE)
    private List<Room> roomList;

    @Override
    public CinemaDTO toDto() {
//
//        List<RoomDTO> roomDTOList = roomList.stream()
//                .map(Room::toDto).toList();
        List<String> idStringRoom = new ArrayList<>();
        if (roomList == null) {
            idStringRoom = new ArrayList<>();
        } else {

            List<Long> idLongRoom = roomList.stream()
                    .map(Room::getId).toList();

            for (Long id : idLongRoom) {
                idStringRoom.add(id.toString());
            }
        }

        return CinemaDTO.builder()
                .id(numberToString(id))
                .name(name)
                .idRooms(idStringRoom)
                .build();
    }
}
