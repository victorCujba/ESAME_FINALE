package it.euris.progettocinema.demo.service;

import it.euris.progettocinema.demo.data.model.Cinema;

import java.util.List;

public interface CinemaService {

    List<Cinema> findAll();

    Cinema insert(Cinema cinema);

    Cinema update(Cinema cinema);

    Boolean deleteById(Long id);

    Cinema findById(Long id);

}
