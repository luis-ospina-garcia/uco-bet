package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityStateDoesNotExistsExeption;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;

@Service
public class StateDoesExistsRuleImpl implements StateDoesExistsRule {
	
	private final StateRepository stateRepository;

    public StateDoesExistsRuleImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

	@Override
	public void validate(UUID data) {
		if(stateRepository.existsById(data)) {
			throw CityStateDoesNotExistsExeption.create();
	}
		
	}

}
