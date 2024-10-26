package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;


@Service
public final class RegisterNewCityImpl implements RegisterNewCity {
	
	private CityRepository cityRepository;
	private RegisterNewCityRulesValidator registerNewCityRulesValidator;
	
	public RegisterNewCityImpl(final CityRepository cityRepository,
			final RegisterNewCityRulesValidator registerNewCityRulesValidator) {
		
		this.cityRepository = cityRepository;
		this.registerNewCityRulesValidator = registerNewCityRulesValidator;
	}

	@Override
	public void execute(CityDomain domain) {

		// Rules validation
		registerNewCityRulesValidator.validate(domain);

		// Data Mapper -> Domain -> Entity
		final var cityEntity = CityEntity.create(null);

		// Save CityEntity
		cityRepository.save(cityEntity);
		
		// Notificar al administrador sobre la creacion de la nueva ciudad 
		
		//1. El correo del administrador esta en un lugar parametrizado (Parametres Building Block)
		//2. El asunto del correo esta en un lugar parametrizado
		//3: El cuerpo del correo esta en un lugar parametrizado

	}
 
}
