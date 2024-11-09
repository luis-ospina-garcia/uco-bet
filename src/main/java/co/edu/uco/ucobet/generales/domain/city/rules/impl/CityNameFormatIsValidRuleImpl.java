package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityNameFormatIsNotValidExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;

@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule{
	
	
	private MessageCatalogService messageCatalogService;
	
	public CityNameFormatIsValidRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public void validate(String data) {
		if (TextHelper.isEmpty(data) || !data.matches("^[a-zA-Z\\s]+$")) {
			throw CityNameFormatIsNotValidExeption.create(messageCatalogService);
		}
	}
}
