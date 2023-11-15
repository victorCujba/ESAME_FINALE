package it.euris.progettocinema.demo.service;


import it.euris.progettocinema.demo.data.model.Spectator;

import java.util.List;

public interface SpectatorService {

    List<Spectator> findAll();

    Spectator insert(Spectator spectator);

    Spectator update(Spectator spectator);

    Boolean deleteById(Long id);

    Spectator findById(Long id);

}
