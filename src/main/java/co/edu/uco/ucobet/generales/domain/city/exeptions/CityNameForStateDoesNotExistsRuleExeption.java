package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityNameForStateDoesNotExistsRuleExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	public CityNameForStateDoesNotExistsRuleExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final CityNameForStateDoesNotExistsRuleExeption create() {
		var userMessage = " no existe una ciudad con este nombre en el departamento..";
		return new CityNameForStateDoesNotExistsRuleExeption(userMessage);
	}

}
