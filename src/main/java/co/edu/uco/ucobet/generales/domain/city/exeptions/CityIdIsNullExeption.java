package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogImpl;

public class CityIdIsNullExeption extends RuleUcobetException{


	private static final long serialVersionUID = 1L;
	
	public CityIdIsNullExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIdIsNullExeption create(final MessageCatalogImpl messageCatalogService) {
		var userMessage =messageCatalogService.getMessage("0011") ;
		return new CityIdIsNullExeption(userMessage);
	}

}
