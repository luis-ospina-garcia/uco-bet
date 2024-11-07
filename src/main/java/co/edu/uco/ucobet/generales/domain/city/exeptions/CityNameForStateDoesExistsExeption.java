package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;

public class CityNameForStateDoesExistsExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	public CityNameForStateDoesExistsExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final CityNameForStateDoesExistsExeption create(final MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0014") ;
		return new CityNameForStateDoesExistsExeption(userMessage);
	}

}
