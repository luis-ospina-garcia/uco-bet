package co.edu.uco.ucobet.generales.application.primaryports.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.CountryDTO;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;


@Mapper 
public interface CountryDTOMapper {
	
	CountryDTOMapper INSTANCE = Mappers.getMapper(CountryDTOMapper.class);

	CountryDTO dtotoToDomain(CountryDomain domain);

	CountryDomain domaintoDto(CountryDTO dto);

	List<CountryDTO> toEntityCollection(List<CountryDomain> domainCollection);

	List<CountryDomain> toDomainCollection(List<CountryDTO> dtoCollection);
	
	
}
