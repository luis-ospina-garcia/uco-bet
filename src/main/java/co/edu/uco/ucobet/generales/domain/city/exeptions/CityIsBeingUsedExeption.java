package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalog;

public class CityIsBeingUsedExeption extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	public CityIsBeingUsedExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIsBeingUsedExeption create(final MessageCatalog messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0012") ;
		return new CityIsBeingUsedExeption(userMessage);
	}

}
