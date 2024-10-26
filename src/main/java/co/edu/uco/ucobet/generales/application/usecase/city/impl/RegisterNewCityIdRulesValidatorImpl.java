package co.edu.uco.ucobet.generales.application.usecase.city.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityIdDoesExistsExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;

@Service
public final  class RegisterNewCityIdRulesValidatorImpl implements RegisterNewCityIdRulesValidator {

	private CityIdDoesNotExistsRule cityIdDoesNotExistsRule;

	public RegisterNewCityIdRulesValidatorImpl(final CityIdDoesNotExistsRule cityIdDoesNotExistsRule) {
		
		this.cityIdDoesNotExistsRule = cityIdDoesNotExistsRule;
	}

	@Override
	public void validate(final CityDomain data) {
		data.generateId();
		try {
			cityIdDoesNotExistsRule.validate(data.getId());
		} catch (final CityIdDoesExistsExeption exception) {
			validate(data);
		}

	}


	
}
