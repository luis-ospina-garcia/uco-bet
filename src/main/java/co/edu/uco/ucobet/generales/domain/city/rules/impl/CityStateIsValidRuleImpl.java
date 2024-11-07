package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.CountryEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.domain.city.exeptions.CityStateIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityStateIsValidRule;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;

public class CityStateIsValidRuleImpl implements CityStateIsValidRule {
	
	private StateRepository stateRepository;
	
	@Autowired
	private MessageCatalogService messageCatalogService;

	public CityStateIsValidRuleImpl(StateRepository stateRepository, MessageCatalogService messageCatalogService) {
		super();
		this.stateRepository = stateRepository;
		this.messageCatalogService = messageCatalogService;
	}



	@Override
	public void validate(StateDomain data) {
		
		var stateEntity = StateEntity.create().setId(data.getId()).setName(data.getName())
				.setCountry(CountryEntityMapper.INSTANCE.toEntity(data.getCountry()));

		var resultado = stateRepository.findByfilter(stateEntity);

		if (!resultado.isEmpty()) {
			throw CityStateIsNotValidException.create(messageCatalogService);
		}
		
	}

}
