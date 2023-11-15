package it.euris.progettocinema.demo.service.impl;

import it.euris.progettocinema.demo.data.model.Room;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.repository.RoomRepository;
import it.euris.progettocinema.demo.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room insert(Room movie) {
        return roomRepository.save(movie);
    }

    @Override
    public Room update(Room movie) {
        if (movie.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return roomRepository.save(movie);
    }

    @Override
    public Boolean deleteById(Long id) {
        roomRepository.deleteById(id);
        return roomRepository.findById(id).isEmpty();
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(Room.builder().build());
    }
}
