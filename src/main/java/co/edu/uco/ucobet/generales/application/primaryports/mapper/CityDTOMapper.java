package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

public interface CityDTOMapper {
	

	CityDTOMapper INSTANCE = Mappers.getMapper(CityDTOMapper.class);

	CityDomain dtoToDomain(RegisterNewCityDTO dto);

	RegisterNewCityDTO domainToDto(CityDomain domain);

	List<RegisterNewCityDTO> domainToDtoCollection(List<CityDomain> domainCollection);

	List<CityDomain> dtoToDomainCollection(List<RegisterNewCityDTO> dtoCollection);


}
