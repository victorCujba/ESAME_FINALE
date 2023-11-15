package it.euris.progettocinema.demo.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.progettocinema.demo.data.archetype.Dto;
import it.euris.progettocinema.demo.data.enums.MovieType;
import it.euris.progettocinema.demo.data.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieDTO implements Dto {
    @JsonIgnore
    private String id;
    private String title;
    private String author;
    private String producer;
    @JsonIgnore
    private MovieType type;
    private String minimalAge;
    private String length;


    @Override
    public Movie toModel() {
        return Movie.builder()
                .title(title)
                .author(author)
                .producer(producer)
                .type(movieTypeToString(type))
                .minimalAge(stringToInteger(minimalAge))
                .length(stringToInteger(length))
                .build();
    }
}
