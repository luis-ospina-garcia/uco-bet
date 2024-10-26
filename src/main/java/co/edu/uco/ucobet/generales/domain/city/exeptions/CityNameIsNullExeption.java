package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameIsNullExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityNameIsNullExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameIsNullExeption create() {
		var userMessage = "El nombre de la ciudad no puede ser nulo";
		return new CityNameIsNullExeption(userMessage);
		
	}
	

}
