package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.city.exeptions.CityNameLenghtIsNotValidExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghtIsValidRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogImpl;

@Service
public class CityNameLenghIsValidRuleImpl implements CityNameLenghtIsValidRule {
	
	
	private MessageCatalogImpl messageCatalogService;
	
	public CityNameLenghIsValidRuleImpl(MessageCatalogImpl messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}

	private static final int MIN_NAME_LENGTH = 3;
	private static final int MAX_NAME_LENGTH = 255;

	@Override
	public void validate(String data) {
		if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
			throw CityNameLenghtIsNotValidExeption.create(messageCatalogService);
		}
	}

}
