package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public final class CityIdDoesExistsExeption extends RuleUcobetException {

	
	private static final long serialVersionUID = 1L;
	
	private CityIdDoesExistsExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIdDoesExistsExeption create() {
		var userMessage = "Ya existe una ciudad con este id";
		return new CityIdDoesExistsExeption(userMessage);
	}

}
