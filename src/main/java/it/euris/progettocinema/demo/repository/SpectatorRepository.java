package it.euris.progettocinema.demo.repository;

import it.euris.progettocinema.demo.data.model.Spectator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpectatorRepository extends JpaRepository<Spectator, Long> {
}
