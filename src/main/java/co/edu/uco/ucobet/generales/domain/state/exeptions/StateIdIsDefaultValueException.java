package co.edu.uco.ucobet.generales.domain.state.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;

public class StateIdIsDefaultValueException extends RuleUcobetException{

	private static final long serialVersionUID = 1L;

	private StateIdIsDefaultValueException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateIdIsDefaultValueException create(final MessageCatalogService messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0007");
		return new StateIdIsDefaultValueException(userMessage);
	}

}
