package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameIsEmptyExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityNameIsEmptyExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameIsEmptyExeption create() {
		var userMessage = "El nombre de la ciudad no puede ser vacio";
		return new CityNameIsEmptyExeption(userMessage);
	}

}
