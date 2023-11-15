package it.euris.progettocinema.demo.service.impl;

import it.euris.progettocinema.demo.data.model.Movie;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.repository.MovieRepository;
import it.euris.progettocinema.demo.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie insert(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        if (movie.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return movieRepository.save(movie);
    }

    @Override
    public Boolean deleteById(Long id) {
        movieRepository.deleteById(id);
        return movieRepository.findById(id).isEmpty();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(Movie.builder().build());
    }
}
