package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;


import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityIdDoesNotExistsRuleExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistsRule;

public final class CityIdDoesExistsRuleImpl implements CityIdDoesExistsRule {
	
	private CityRepository cityRepository;
	
	
	@Override
	public void validate(UUID data) {
		
		if(!cityRepository.existsById(data)) {
			throw CityIdDoesNotExistsRuleExeption.create();
		}	
	}

}
