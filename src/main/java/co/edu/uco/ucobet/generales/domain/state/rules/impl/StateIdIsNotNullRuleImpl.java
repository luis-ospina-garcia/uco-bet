package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.exeptions.StateIdIsNullException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotNullRule;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapter.messagecatalog.MessageCatalogService;


@Service
public class StateIdIsNotNullRuleImpl implements StateIdIsNotNullRule  {
	

	private MessageCatalogService messageCatalogService;

	public StateIdIsNotNullRuleImpl(MessageCatalogService messageCatalogService) {
		this.messageCatalogService = messageCatalogService;
	}

	@Override
	public void validate(UUID data) {
		
		if (ObjectHelper.isNull(data) || UUIDHelper.isDefault(data)) {
			throw StateIdIsNullException.create(messageCatalogService);
		}
		
	}

}
