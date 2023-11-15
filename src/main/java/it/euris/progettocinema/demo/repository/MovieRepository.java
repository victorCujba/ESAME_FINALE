package it.euris.progettocinema.demo.repository;

import it.euris.progettocinema.demo.data.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
