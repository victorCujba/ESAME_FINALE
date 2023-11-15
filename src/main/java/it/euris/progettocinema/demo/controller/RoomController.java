package it.euris.progettocinema.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.progettocinema.demo.data.dto.MovieDTO;
import it.euris.progettocinema.demo.data.dto.RoomDTO;
import it.euris.progettocinema.demo.data.model.Movie;
import it.euris.progettocinema.demo.data.model.Room;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.service.MovieService;
import it.euris.progettocinema.demo.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    @GetMapping("/v1")
    @Operation(description = """
            This method is used to retrieve all  Rooms from the database.
            """)
    public List<RoomDTO> getAllRooms() {
        return roomService.findAll().stream().map(Room::toDto).toList();
    }

    @PostMapping("/v1")
    @Operation(description = """
            This method is used to save a new Room to data base.
            """)
    public RoomDTO insertRoom(@RequestBody RoomDTO roomDTO) {
        Room room = roomDTO.toModel();
        return roomService.insert(room).toDto();
    }


    @PutMapping("/v1")
    @Operation(description = """
            This method is used to update existing Room in data base.
            """)
    public RoomDTO updateRoom(@RequestBody RoomDTO roomDTO) {
        try {
            Room room = roomDTO.toModel();
            return roomService.update(room).toDto();
        } catch (IdMustNotBeNullException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
