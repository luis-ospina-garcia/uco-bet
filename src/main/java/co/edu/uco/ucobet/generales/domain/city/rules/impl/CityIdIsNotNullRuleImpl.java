package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityIdIsNullExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;


@Service
public final class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {
	

	@Override
	public void validate(UUID data) {
		if(ObjectHelper.isNull(data) ) {
			
			throw CityIdIsNullExeption.create();

			
		}
		
	}

}
