package co.edu.uco.ucobet.generales.application.primaryports.dto;

import java.util.UUID;

public class CountryDTO {
	
	private UUID  id;
	private String name;
	
	public CountryDTO() {
		super();
		setId(id);
		setName(name);
	}
	
	
	public final  UUID getId() {
		return id;
	}
	public final  void setId(final UUID id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final  void setName(final String name) {
		this.name = name;
	}
	
}
