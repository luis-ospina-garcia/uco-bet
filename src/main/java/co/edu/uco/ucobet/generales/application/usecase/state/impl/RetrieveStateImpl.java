package co.edu.uco.ucobet.generales.application.usecase.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.application.usecase.state.RetrieveState;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Service
public class RetrieveStateImpl implements RetrieveState {
	
	private StateRepository stateRepository;

	public RetrieveStateImpl( final StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public List<StateDomain> execute(StateDomain domain) {
		
		var stateEntity = StateEntityMapper.INSTANCE.toEntity(domain);
		var resultadosEntity = stateRepository.findByfilter(stateEntity);
		return StateEntityMapper.INSTANCE.toDomainCollection(resultadosEntity);
	}

}
