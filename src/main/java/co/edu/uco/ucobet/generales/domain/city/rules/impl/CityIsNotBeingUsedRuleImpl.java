package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityIsBeingUsedExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeingUsedRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;


@Service
public class CityIsNotBeingUsedRuleImpl implements CityIsNotBeingUsedRule{
	
	private CityRepository cityRepository;
	@Autowired
	private MessageCatalogService messageCatalogService;
	
	public CityIsNotBeingUsedRuleImpl(CityRepository cityRepository, MessageCatalogService messageCatalogService) {
		super();
		this.cityRepository = cityRepository;
		this.messageCatalogService = messageCatalogService;
	}




	@Override
	public void validate(UUID data) {
		if(cityRepository.isCityBeingUsed(data)) {
			throw CityIsBeingUsedExeption.create(messageCatalogService);
		}
	}

}
