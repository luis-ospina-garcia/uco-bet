package co.edu.uco.ucobet.generales.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

public interface StateEntityMapper {
	
	StateEntityMapper INSTANCE = Mappers.getMapper(StateEntityMapper.class);

	StateEntity toEntity(StateDomain domain);

	StateDomain toDomain(StateEntity entity);

	List<StateEntity> toEntityCollection(List<StateDomain> domainCollection);

	List<StateDomain> toDomainCollection(List<StateEntity> entityCollection);

}
