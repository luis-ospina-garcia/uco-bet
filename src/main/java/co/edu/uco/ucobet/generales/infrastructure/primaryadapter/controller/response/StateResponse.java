package co.edu.uco.ucobet.generales.infrastructure.primaryadapter.controller.response;

import java.util.ArrayList;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RetrieveStateDTO;

public class StateResponse extends Response<RetrieveStateDTO>{
	
	public StateResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
