package it.euris.progettocinema.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.progettocinema.demo.data.dto.SpectatorDTO;
import it.euris.progettocinema.demo.data.model.Spectator;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.service.SpectatorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/spectators")
public class SpectatorController {


    private SpectatorService spectatorService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all Spectators from the database.
            """)
    public List<SpectatorDTO> getAllSpectators() {
        return spectatorService.findAll().stream().map(Spectator::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Room to data base.
            """)
    public SpectatorDTO insertSpectator(@RequestBody SpectatorDTO spectatorDTO) {
        Spectator spectator = spectatorDTO.toModel();
        return spectatorService.insert(spectator).toDto();
    }


    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update existing Spectator in data base.
            """)
    public SpectatorDTO updateSpectator(@RequestBody SpectatorDTO spectatorDTO) {
        try {
            Spectator spectator = spectatorDTO.toModel();
            return spectatorService.update(spectator).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
