package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;
import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityNameForStateDoesExistsExeption;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalog;

@Service
public class CityNameForStateDoesNotExistsRuleImpl implements CityNameForStateDoesNotExistsRule {
    
    private final CityRepository cityRepository;
    
    private MessageCatalog messageCatalogService;

    public CityNameForStateDoesNotExistsRuleImpl(CityRepository cityRepository,
			MessageCatalog messageCatalogService) {
		this.cityRepository = cityRepository;
		this.messageCatalogService = messageCatalogService;
	}



	@Override
    public void validate(CityDomain data) {
        
        var cityEntityFilter = CityEntity.create()
                                         .setName(data.getName())
                                         .setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));

        var resultados = cityRepository.findByfilter(cityEntityFilter);

        if (!resultados.isEmpty()) {
            throw CityNameForStateDoesExistsExeption.create(messageCatalogService);
        }
    }
}
