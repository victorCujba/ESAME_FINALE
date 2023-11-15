package it.euris.progettocinema.demo.service;

import it.euris.progettocinema.demo.data.model.Room;

import java.util.List;

public interface RoomService {

    List<Room> findAll();

    Room insert(Room movie);

    Room update(Room movie);

    Boolean deleteById(Long id);

    Room findById(Long id);

}
