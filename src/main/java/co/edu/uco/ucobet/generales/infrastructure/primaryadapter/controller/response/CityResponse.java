package co.edu.uco.ucobet.generales.infrastructure.primaryadapter.controller.response;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;

public class CityResponse extends Response<RegisterNewCityDTO> {

    public CityResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
