package it.euris.progettocinema.demo.repository;

import it.euris.progettocinema.demo.data.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
