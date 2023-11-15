package it.euris.progettocinema.demo.data.model;

import it.euris.progettocinema.demo.data.archetype.Model;
import it.euris.progettocinema.demo.data.dto.MovieDTO;
import it.euris.progettocinema.demo.data.enums.MovieType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "movie")
public class Movie implements Model {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "producer")
    private String producer;

    @Column(name = "movie_type")
    private String type;

    @Column(name = "limit_age")
    private Integer minimalAge;

    @Column(name = "length")
    private Integer length;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Room> rooms;


    @Override
    public MovieDTO toDto() {
        return MovieDTO.builder()
                .id(numberToString(id))
                .title(title)
                .author(author)
                .producer(producer)
                .type(stringToMovieType(type))
                .minimalAge(numberToString(minimalAge))
                .length(numberToString(length))
                .build();
    }
}
