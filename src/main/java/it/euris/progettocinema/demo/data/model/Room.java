package it.euris.progettocinema.demo.data.model;

import it.euris.progettocinema.demo.data.archetype.Model;
import it.euris.progettocinema.demo.data.dto.CinemaDTO;
import it.euris.progettocinema.demo.data.dto.RoomDTO;
import it.euris.progettocinema.demo.data.dto.SpectatorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.numberToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "room")
public class Room implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private Integer capacity;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Spectator> spectatorList;

    @ManyToOne
    @JoinColumn(name = "id_movie")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "id_cinema")
    private Cinema cinema;


    @Override
    public RoomDTO toDto() {

        List<SpectatorDTO> spectatorDTOList = spectatorList.stream()
                .map(Spectator::toDto).toList();

        return RoomDTO.builder()
                .id(numberToString(id))
                .name(name)
                .capacity(numberToString(capacity))
                .spectatorDTOList(spectatorDTOList)
                .idMovie(numberToString(movie.getId()))
                .idCinema(numberToString(cinema.getId()))
                .build();
    }
}
