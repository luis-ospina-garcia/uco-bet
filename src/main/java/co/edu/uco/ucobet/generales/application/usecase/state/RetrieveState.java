package co.edu.uco.ucobet.generales.application.usecase.state;

import java.util.List;

import co.edu.uco.ucobet.generales.application.usecase.UseCaseWithReturn;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

public interface RetrieveState extends UseCaseWithReturn<StateDomain, List<StateDomain>>{
	
}

