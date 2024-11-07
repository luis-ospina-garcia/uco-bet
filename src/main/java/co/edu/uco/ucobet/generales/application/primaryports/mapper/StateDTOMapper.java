package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper(componentModel = "spring")
public interface StateDTOMapper {

    StateDTOMapper INSTANCE = Mappers.getMapper(StateDTOMapper.class);
    
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "country", target = "country")
    StateDomain toDomain(RetrieveStateDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "country", target = "country")
    RetrieveStateDTO toDto(StateDomain stateDomain);

    	List<RetrieveStateDTO> toDtoCollection(List<StateDomain>domains);
    	
}


