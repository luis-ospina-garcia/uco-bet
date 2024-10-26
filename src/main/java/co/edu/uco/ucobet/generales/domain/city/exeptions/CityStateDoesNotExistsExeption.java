package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityStateDoesNotExistsExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityStateDoesNotExistsExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final CityStateDoesNotExistsExeption create() {
		var userMessage = "El estado asociado a la ciudad no existe.";
		return new CityStateDoesNotExistsExeption(userMessage);
	}

}
