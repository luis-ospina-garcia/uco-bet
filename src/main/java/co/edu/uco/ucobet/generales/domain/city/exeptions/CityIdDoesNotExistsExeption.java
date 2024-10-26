package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIdDoesNotExistsExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityIdDoesNotExistsExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final CityIdDoesNotExistsExeption create() {
		var userMessage = " no existe la ciudad con el id indicado..";
		return new CityIdDoesNotExistsExeption(userMessage);
	}

}
