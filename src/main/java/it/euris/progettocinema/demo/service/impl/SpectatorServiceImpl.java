package it.euris.progettocinema.demo.service.impl;

import it.euris.progettocinema.demo.data.model.Spectator;
import it.euris.progettocinema.demo.exceptions.IdMustNotBeNullException;
import it.euris.progettocinema.demo.repository.SpectatorRepository;
import it.euris.progettocinema.demo.service.SpectatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpectatorServiceImpl implements SpectatorService {

    private SpectatorRepository spectatorRepository;

    @Override
    public List<Spectator> findAll() {
        return spectatorRepository.findAll();
    }

    @Override
    public Spectator insert(Spectator spectator) {
        return spectatorRepository.save(spectator);
    }

    @Override
    public Spectator update(Spectator spectator) {
        if (spectator.getIdSpectator() == null) {
            throw new IdMustNotBeNullException();
        }
        return spectatorRepository.save(spectator);
    }

    @Override
    public Boolean deleteById(Long id) {
        spectatorRepository.deleteById(id);
        return spectatorRepository.findById(id).isEmpty();
    }

    @Override
    public Spectator findById(Long id) {
        return spectatorRepository.findById(id).orElse(Spectator.builder().build());
    }
}
