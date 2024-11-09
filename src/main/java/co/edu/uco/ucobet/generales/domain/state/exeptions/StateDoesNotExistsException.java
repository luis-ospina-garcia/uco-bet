package co.edu.uco.ucobet.generales.domain.state.exeptions;


import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalog;

public class StateDoesNotExistsException extends RuleUcobetException {
	
	private static final long serialVersionUID = 1L;
	
	private StateDoesNotExistsException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateDoesNotExistsException create(final MessageCatalog messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0005") ;
		return new StateDoesNotExistsException(userMessage);
	}

}
