package it.euris.progettocinema.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.progettocinema.demo.data.dto.CinemaDTO;
import it.euris.progettocinema.demo.data.model.Cinema;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private CinemaService cinemaService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all Cinemas from the database.
            """)
    public List<CinemaDTO> getAllCinemas() {
        return cinemaService.findAll().stream().map(Cinema::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Cinema to data base.
            """)
    public CinemaDTO insertCinema(@RequestBody CinemaDTO cinemaDTO) {
        Cinema cinema = cinemaDTO.toModel();
        return cinemaService.insert(cinema).toDto();
    }


    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update existing Cinema in data base.
            """)
    public CinemaDTO updateCinema(@RequestBody CinemaDTO cinemaDTO) {
        try {
            Cinema cinema = cinemaDTO.toModel();
            return cinemaService.update(cinema).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
