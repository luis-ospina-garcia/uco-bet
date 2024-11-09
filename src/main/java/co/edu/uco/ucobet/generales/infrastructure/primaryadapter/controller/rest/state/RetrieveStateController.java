package co.edu.uco.ucobet.generales.infrastructure.primaryadapter.controller.rest.state;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.ucobet.generales.application.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.RetrieveStateInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapter.controller.response.StateResponse;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;

@RestController
@RequestMapping("/general/api/v1/states")
public class RetrieveStateController {

    private final RetrieveStateInteractor retrieveStateInteractor;
    private final MessageCatalogService messageCatalogService;

    public RetrieveStateController(RetrieveStateInteractor retrieveStateInteractor, MessageCatalogService messageCatalogService) {
        this.retrieveStateInteractor = retrieveStateInteractor;
        this.messageCatalogService = messageCatalogService;
    }

    @GetMapping
    public ResponseEntity<StateResponse> consultar() {
        var httpStatusCode = HttpStatus.ACCEPTED;
        var stateResponse = new StateResponse();

        try {
            var retrieveStateDto = RetrieveStateDTO.create();
            stateResponse.setDatos(retrieveStateInteractor.execute(retrieveStateDto));
            stateResponse.getMensajes().add(messageCatalogService.getMessage("0001"));
        } catch (RuleUcobetException exception) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            stateResponse.getMensajes().add(exception.getMessage());
            exception.printStackTrace();
        } catch (Exception exception) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            stateResponse.getMensajes().add(messageCatalogService.getMessage("0002"));
            exception.printStackTrace();
        }

        return new ResponseEntity<>(stateResponse, httpStatusCode);
    }
}
