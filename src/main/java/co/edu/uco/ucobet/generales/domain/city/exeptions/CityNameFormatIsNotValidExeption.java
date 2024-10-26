package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameFormatIsNotValidExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityNameFormatIsNotValidExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameFormatIsNotValidExeption create() {
		var userMessage = "El formato del nombre no es valido";
		return new CityNameFormatIsNotValidExeption(userMessage);
	}

}
