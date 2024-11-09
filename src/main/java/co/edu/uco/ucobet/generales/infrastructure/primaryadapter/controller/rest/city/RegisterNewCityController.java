package co.edu.uco.ucobet.generales.infrastructure.primaryadapter.controller.rest.city;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.crosscutting.exception.RuleUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.infrastructure.primaryadapter.controller.response.CityResponse;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogImpl;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.notificationservice.EmailService;

@RestController
@RequestMapping("/general/api/v1/cities")
public class RegisterNewCityController {

    private final RegisterNewCityInteractor registerNewCityInteractor;
    private final MessageCatalogImpl messageCatalogService;
    private final EmailService emailService;

    public RegisterNewCityController(RegisterNewCityInteractor registerNewCityInteractor, 
                                     MessageCatalogImpl messageCatalogService, 
                                     EmailService emailService) {
        this.registerNewCityInteractor = registerNewCityInteractor;
        this.messageCatalogService = messageCatalogService;
        this.emailService = emailService;
    }

    @GetMapping
    public RegisterNewCityDTO getDummy() {
        return RegisterNewCityDTO.create("Rionegro", UUIDHelper.generate());
    }

    @PostMapping
    public ResponseEntity<CityResponse> registrarCiudad(@Validated @RequestBody RegisterNewCityDTO dto) {
        var httpStatusCode = HttpStatus.CREATED;
        var ciudadResponse = new CityResponse();

        try {
            registerNewCityInteractor.execute(dto);
            ciudadResponse.getMensajes().add(messageCatalogService.getMessage("0003"));
            emailService.sendEmailNotification(dto.getCityName());
        } catch (RuleUcobetException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            ciudadResponse.getMensajes().add(excepcion.getUserMessage());
        } catch (Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            ciudadResponse.getMensajes().add(messageCatalogService.getMessage("0004"));
        }

        return new ResponseEntity<>(ciudadResponse, httpStatusCode);
    }
}
