package it.euris.progettocinema.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.progettocinema.demo.data.dto.MovieDTO;
import it.euris.progettocinema.demo.data.enums.MovieType;
import it.euris.progettocinema.demo.data.model.Movie;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.movieTypeToString;

@AllArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all Movies from the database.
            """)
    public List<MovieDTO> getAllMovies() {
        return movieService.findAll().stream().map(Movie::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Movie to data base.
            """)
    public MovieDTO insertMovie(@RequestBody MovieDTO movieDTO, @RequestParam MovieType type) {
        Movie movie = movieDTO.toModel();
        movie.setType(movieTypeToString(type));
        movie.setType(movieTypeToString(type));
        return movieService.insert(movie).toDto();
    }


    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update existing Movie in data base.
            """)
    public MovieDTO updateMovie(@RequestBody MovieDTO movieDTO) {
        try {
            Movie movie = movieDTO.toModel();
            return movieService.update(movie).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
