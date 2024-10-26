package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;

@Service
public final  class RegisterNewCityStateRulesValidatorImpl implements RegisterNewCityStateRulesValidator {
	
	
	private StateDoesExistsRule stateDoesExistsRule;
	private StateIdIsNotNullRule stateIdIsNotNullRule;
	private StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule;

	public RegisterNewCityStateRulesValidatorImpl(final StateDoesExistsRule stateDoesExistsRule,
			final StateIdIsNotNullRule stateIdIsNotNullRule,final StateIdIsNotDefaultValueRule stateIdIsNotDefaultValueRule) {
		
		this.stateDoesExistsRule = stateDoesExistsRule;
		this.stateIdIsNotNullRule = stateIdIsNotNullRule;
		this.stateIdIsNotDefaultValueRule = stateIdIsNotDefaultValueRule;
	}

	@Override
	public void validate(final UUID data) {
		validateState(data);
		
	}

	private void validateState(final UUID data) {
		stateDoesExistsRule.validate(data);
		stateIdIsNotNullRule.validate(data);
		stateIdIsNotDefaultValueRule.validate(data);

	}
	
}
