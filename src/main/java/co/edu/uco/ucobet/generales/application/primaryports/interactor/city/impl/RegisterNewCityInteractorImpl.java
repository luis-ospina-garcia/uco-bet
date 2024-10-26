package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {
	
	private RegisterNewCity registerNewCity;
	
	public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCity) {
		this.registerNewCity = registerNewCity;
	}

	@Override
	public void execute(RegisterNewCityDTO data) {
		
		 final var cityDomain = new CityDomain(null,null,null);
		
		registerNewCity.execute(cityDomain);
		
	}

	
}
