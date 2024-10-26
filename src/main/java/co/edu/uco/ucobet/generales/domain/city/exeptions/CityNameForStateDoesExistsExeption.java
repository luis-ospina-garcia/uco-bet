package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameForStateDoesExistsExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	public CityNameForStateDoesExistsExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final CityNameForStateDoesExistsExeption create() {
		var userMessage = " no existe una ciudad con este nombre en el departamento..";
		return new CityNameForStateDoesExistsExeption(userMessage);
	}

}
