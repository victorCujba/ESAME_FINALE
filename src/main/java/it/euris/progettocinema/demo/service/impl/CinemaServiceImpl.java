package it.euris.progettocinema.demo.service.impl;

import it.euris.progettocinema.demo.data.model.Cinema;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.repository.CinemaRepository;
import it.euris.progettocinema.demo.service.CinemaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CinemaServiceImpl implements CinemaService {

    private CinemaRepository cinemaRepository;

    @Override
    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    @Override
    public Cinema insert(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    @Override
    public Cinema update(Cinema cinema) {
        if (cinema.getId() == null) {
            throw new IdMustNotBeNullException();
        }
        return cinemaRepository.save(cinema);
    }

    @Override
    public Boolean deleteById(Long id) {
        cinemaRepository.deleteById(id);
        return cinemaRepository.findById(id).isEmpty();
    }

    @Override
    public Cinema findById(Long id) {
        return cinemaRepository.findById(id).orElse(Cinema.builder().build());
    }

    @Override
    public Integer getAllIncome() {
        return null;
    }
}
