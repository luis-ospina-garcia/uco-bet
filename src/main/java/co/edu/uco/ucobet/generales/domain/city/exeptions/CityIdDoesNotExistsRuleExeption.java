package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;

public class CityIdDoesNotExistsRuleExeption extends RuleUcobetException{

	private static final long serialVersionUID = 1L;
	
	private CityIdDoesNotExistsRuleExeption(final String userMessage) {
		super(userMessage, userMessage, new Exception());
	}
	
	public static final CityIdDoesNotExistsRuleExeption create() {
		var userMessage = " no existe la ciudad con el id indicado..";
		return new CityIdDoesNotExistsRuleExeption(userMessage);
	}

}
