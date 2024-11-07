package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;


import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.RegisterNewCityDTOMapper;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {
	
	private RegisterNewCity registerNewCity;
	
	public RegisterNewCityInteractorImpl(final RegisterNewCity registerNewCity) {
		this.registerNewCity = registerNewCity;
	}

	@Override
	public void execute(RegisterNewCityDTO data) {
		
		 var cityDomain = RegisterNewCityDTOMapper.INSTANCE.toDomain(data);
		 
		 
		 registerNewCity.execute(cityDomain);
		 
	}
}
