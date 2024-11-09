package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalog;

public final class CityIdDoesExistsExeption extends RuleUcobetException {

	
	private static final long serialVersionUID = 1L;
	
	public CityIdDoesExistsExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIdDoesExistsExeption create(final MessageCatalog messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0009") ;
		return new CityIdDoesExistsExeption(userMessage);
	}

}
