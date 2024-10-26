package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityNameFormatIsNotValidExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;


@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule{

	@Override
	public void validate(String data) {
		if(TextHelper.isEmpty(data)) {
			throw CityNameFormatIsNotValidExeption.create();
		}
	}

}
