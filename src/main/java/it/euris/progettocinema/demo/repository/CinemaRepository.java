package it.euris.progettocinema.demo.repository;

import it.euris.progettocinema.demo.data.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
