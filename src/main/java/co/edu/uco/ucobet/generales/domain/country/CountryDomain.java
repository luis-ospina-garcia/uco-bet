package co.edu.uco.ucobet.generales.domain.country;

import java.util.UUID;
import co.edu.uco.ucobet.generales.domain.Domain;

public class CountryDomain extends Domain {
	
	private String name;

	protected CountryDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}

	public final String getName() {
		return name;
	}

	private final void setName(final String name) {
		this.name = name;
	}
	
}
