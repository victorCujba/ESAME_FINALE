package it.euris.progettocinema.demo.service;

import it.euris.progettocinema.demo.data.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();

    Movie insert(Movie movie);

    Movie update(Movie movie);

    Boolean deleteById(Long id);

    Movie findById(Long id);

}
