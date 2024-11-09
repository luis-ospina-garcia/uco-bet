package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityStateIsNotValidException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalog;

@Service
public class StateDoesExistsRuleImpl implements StateDoesExistsRule {

    private final StateRepository stateRepository;
    
    
	private MessageCatalog messageCatalogService;

    public StateDoesExistsRuleImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public void validate(UUID data) {
        // Cambiar la condición para lanzar la excepción si el estado NO existe
        if (!stateRepository.existsById(data)) { // Usar '!' para verificar que el estado no existe
            throw CityStateIsNotValidException.create(messageCatalogService); // Lanzar la excepción si no existe
        }
    }
}
