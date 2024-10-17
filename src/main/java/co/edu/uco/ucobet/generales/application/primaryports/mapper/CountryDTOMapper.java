package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper 
public interface CountryDTOMapper {
	
    CountryDTOMapper INSTANCE = Mappers.getMapper(CountryDTOMapper.class);
    
    
	 
	
}
