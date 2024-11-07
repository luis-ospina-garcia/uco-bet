package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;

public class CityNameIsNullExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	public CityNameIsNullExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameIsNullExeption create(final MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0015") ;
		return new CityNameIsNullExeption(userMessage);
		
	}
	

}
