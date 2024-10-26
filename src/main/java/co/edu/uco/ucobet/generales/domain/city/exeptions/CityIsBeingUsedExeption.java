package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIsBeingUsedExeption extends RuleUcobetException {

	private static final long serialVersionUID = 1L;
	
	private CityIsBeingUsedExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIsBeingUsedExeption create() {
		var userMessage = "La ciudad esta siendo utilizada en otra parte del sistema";
		return new CityIsBeingUsedExeption(userMessage);
	}

}
