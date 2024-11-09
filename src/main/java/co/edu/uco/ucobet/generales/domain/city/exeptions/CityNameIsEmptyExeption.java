package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogImpl;

public class CityNameIsEmptyExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	public CityNameIsEmptyExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameIsEmptyExeption create(final MessageCatalogImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0006");
		return new CityNameIsEmptyExeption(userMessage);
	}

}
