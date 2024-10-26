package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIdIsNullExeption extends RuleUcobetException{


	private static final long serialVersionUID = 1L;
	
	private CityIdIsNullExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
		
	}
	
	public static final CityIdIsNullExeption create() {
		var userMessage = "El Id de la ciudad no puede ser Nulo";
		return new CityIdIsNullExeption(userMessage);
	}

}
