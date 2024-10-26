package co.edu.uco.ucobet.generales.application.usecase.city.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public final  class RegisterNewCityRulesValidatorImpl implements RegisterNewCityRulesValidator {
	
	
	private RegisterNewCityIdRulesValidator cityIdRulesValidator;
	private RegisterNewCityNameRulesValidator cityNameRulesValidator;
	private RegisterNewCityStateRulesValidator cityStateRulesValidator;

	public RegisterNewCityRulesValidatorImpl(final RegisterNewCityIdRulesValidator cityIdRulesValidator,
			final RegisterNewCityNameRulesValidator cityNameRulesValidator,
			final RegisterNewCityStateRulesValidator cityStateRulesValidator) {
		
		this.cityIdRulesValidator = cityIdRulesValidator;
		this.cityNameRulesValidator = cityNameRulesValidator;
		this.cityStateRulesValidator = cityStateRulesValidator;
	}

	@Override
	public void validate(final CityDomain data) {
		cityIdRulesValidator.validate(data);
		cityNameRulesValidator.validate(data);
		cityStateRulesValidator.validate(data.getState().getId());
	}

	
}

