package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
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


		final var cityEntity = CityEntity.create().setId(domain.getId()).setName(domain.getName()).setState(StateEntityMapper.INSTANCE.toEntity(domain.getState()));

		// Save CityEntity
		cityRepository.save(cityEntity);
		
	}
 
}
