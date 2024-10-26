package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

public interface StateDTOMapper {
	
	StateDTOMapper INSTANCE = Mappers.getMapper(StateDTOMapper.class);

	StateDTO toEntity(StateDomain domain);

	StateDomain toDomain(StateDTO dto);

	List<StateDTO> domaintoDomainCollection(List<StateDomain> domainCollection);

	List<StateDomain> dtotoDomainCollection(List<StateDTO> dtoCollection);

}
