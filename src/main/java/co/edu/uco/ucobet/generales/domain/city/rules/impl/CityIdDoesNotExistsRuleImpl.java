package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityIdDoesNotExistsExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesNotExistsRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalog;

@Service
public class CityIdDoesNotExistsRuleImpl implements CityIdDoesNotExistsRule{
	
	private CityRepository cityRepository;
	
	private MessageCatalog messageCatalogService;

	public CityIdDoesNotExistsRuleImpl(CityRepository cityRepository, MessageCatalog messageCatalogService) {
		this.cityRepository = cityRepository;
		this.messageCatalogService = messageCatalogService;
	}



	@Override
	public void validate(UUID data) {
		if(cityRepository.existsById(data)) {
			throw CityIdDoesNotExistsExeption.create(messageCatalogService);
		}
		
		
	}

}
