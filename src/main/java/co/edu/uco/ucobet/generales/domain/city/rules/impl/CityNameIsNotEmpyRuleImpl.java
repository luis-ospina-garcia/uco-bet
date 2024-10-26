package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityNameIsEmptyExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmptyRule;

@Service
public class CityNameIsNotEmpyRuleImpl implements CityNameIsNotEmptyRule {

	@Override
	public void validate(String data) {
		if (TextHelper.isEmpty(data)) {
			throw CityNameIsEmptyExeption.create();
		}

	}

}
