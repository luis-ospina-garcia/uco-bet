package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghtIsValidRule;

@Service
public final  class RegisterNewCityNameRulesValidatorImpl implements RegisterNewCityNameRulesValidator {

	private CityNameLenghtIsValidRule cityNameLenghtIsValidRule;
	private CityNameFormatIsValidRule cityNameFormatIsValidRule;
	private CityNameIsNotEmptyRule cityNameIsNotEmptyRule;
	private CityNameIsNotNullRule cityNameIsNotNullRule;
	private CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule;
	

	public RegisterNewCityNameRulesValidatorImpl(final CityNameLenghtIsValidRule cityNameLenghtIsValidRule,
			final CityNameFormatIsValidRule cityNameFormatIsValidRule, final  CityNameIsNotEmptyRule cityNameIsNotEmptyRule,
			final CityNameIsNotNullRule cityNameIsNotNullRule,
			final CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule) {
		
		this.cityNameLenghtIsValidRule = cityNameLenghtIsValidRule;
		this.cityNameFormatIsValidRule = cityNameFormatIsValidRule;
		this.cityNameIsNotEmptyRule = cityNameIsNotEmptyRule;
		this.cityNameIsNotNullRule = cityNameIsNotNullRule;
		this.cityNameForStateDoesNotExistsRule = cityNameForStateDoesNotExistsRule;
	}

	@Override
	public void validate(final CityDomain data) {
		validateName(data);

	}

	private void validateName(final CityDomain data) {
		cityNameLenghtIsValidRule.validate(data.getName());
		cityNameFormatIsValidRule.validate(data.getName());
		cityNameIsNotEmptyRule.validate(data.getName());
		cityNameIsNotNullRule.validate(data.getName());
		cityNameForStateDoesNotExistsRule.validate(data);
	}
}
	


	

