package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityNameIsNullExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;

@Service
public class CityNameIsNotNullRuleImpl implements CityNameIsNotNullRule {
	
	@Autowired
	private MessageCatalogService messageCatalogService;
	
	public CityNameIsNotNullRuleImpl(MessageCatalogService messageCatalogService) {
		super();
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public void validate(String data) {
		if (TextHelper.isNull(data)) {
			throw CityNameIsNullExeption.create(messageCatalogService);
		}

	}

}
