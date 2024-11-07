package co.edu.uco.ucobet.generales.domain.city.exeptions;

import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;

public class CityStateIsNotValidException extends RuleUcobetException {

    private static final long serialVersionUID = 1L;

    private CityStateIsNotValidException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityStateIsNotValidException create(final MessageCatalogService messageCatalogService) {
        var userMessage = messageCatalogService.getMessage("0017") ;
        return new CityStateIsNotValidException(userMessage);
    }
}
