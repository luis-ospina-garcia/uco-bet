package co.edu.uco.ucobet.generales.application.primaryports.interactor.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.state.RetrieveStateInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.StateDTOMapper;
import co.edu.uco.ucobet.generales.application.usecase.state.RetrieveState;
import co.edu.uco.ucobet.generales.crosscutting.exception.RepositoryUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.exception.UcobetExeception;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class RetrieveStateInteractorImpl implements RetrieveStateInteractor {

	private  RetrieveState retrieveState;
	
	public RetrieveStateInteractorImpl(final RetrieveState retrieveState) {
		this.retrieveState = retrieveState;
	}



	@Override
	public List<RetrieveStateDTO> execute(RetrieveStateDTO data) {
		
		try {
			var stateDomain = StateDTOMapper.INSTANCE.toDomain(data);
			var resultado = retrieveState.execute(stateDomain);
			return StateDTOMapper.INSTANCE.toDtoCollection(resultado);
		} catch (UcobetExeception exception) {
			var mensajeUsuario = "Se ha presentado un problema al consultar la información de los estados";
			throw RepositoryUcobetException.create(mensajeUsuario);
		}
	}
}
