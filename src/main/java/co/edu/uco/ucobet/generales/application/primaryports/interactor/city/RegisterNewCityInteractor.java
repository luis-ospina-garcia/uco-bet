package co.edu.uco.ucobet.generales.application.primaryports.interactor.city;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.InteractorWithoutReturn;

@Service
@Transactional
public interface RegisterNewCityInteractor extends InteractorWithoutReturn<RegisterNewCityDTO> {
	
	
	
	

}
