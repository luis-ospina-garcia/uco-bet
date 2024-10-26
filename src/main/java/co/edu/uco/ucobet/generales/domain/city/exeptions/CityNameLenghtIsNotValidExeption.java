package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameLenghtIsNotValidExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	

	private CityNameLenghtIsNotValidExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityNameLenghtIsNotValidExeption create() {
		var userMessage = "El tamaño del nombre de la ciudad no es correcto";
		return new CityNameLenghtIsNotValidExeption(userMessage);
	}
	
	

}
