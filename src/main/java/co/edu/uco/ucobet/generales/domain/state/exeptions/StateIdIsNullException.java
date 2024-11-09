package co.edu.uco.ucobet.generales.domain.state.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogImpl;

public class StateIdIsNullException extends RuleUcobetException {

	private static final long serialVersionUID = 1L;

	private StateIdIsNullException(final String userMessage) {
		super(userMessage, userMessage, new Exception());

	}

	public static final StateIdIsNullException create(final MessageCatalogImpl messageCatalogService) {
		var userMessage = messageCatalogService.getMessage("0008") ;
		return new StateIdIsNullException(userMessage);
	}

}
