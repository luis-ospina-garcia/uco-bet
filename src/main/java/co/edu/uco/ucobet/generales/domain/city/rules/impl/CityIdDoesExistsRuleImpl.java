package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityIdDoesNotExistsExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdDoesExistsRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogImpl;

@Service
public final class CityIdDoesExistsRuleImpl implements CityIdDoesExistsRule {
	
	private CityRepository cityRepository;
	private MessageCatalogImpl messageCatalogService;
	
	public CityIdDoesExistsRuleImpl(CityRepository cityRepository, MessageCatalogImpl messageCatalogService) {
		this.cityRepository = cityRepository;
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public void validate(UUID data) {
		
		if(!cityRepository.existsById(data)) {
			throw CityIdDoesNotExistsExeption.create(messageCatalogService);
		}	
	}

}
