package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;

public class CityIdDoesNotExistsExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	public CityIdDoesNotExistsExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final CityIdDoesNotExistsExeption create(final MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0010") ;
		return new CityIdDoesNotExistsExeption(userMessage);
	}

}
