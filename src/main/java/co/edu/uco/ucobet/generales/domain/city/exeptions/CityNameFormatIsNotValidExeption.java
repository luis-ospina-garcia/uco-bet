package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalog;

public class CityNameFormatIsNotValidExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	public CityNameFormatIsNotValidExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameFormatIsNotValidExeption create( final MessageCatalog messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0013") ;
		return new CityNameFormatIsNotValidExeption(userMessage);
	}

}
