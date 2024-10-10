package co.edu.uco.ucobet.generales.application.primaryports.dto;

import java.util.UUID;

public class StateDTO {
	
	private UUID id;
	private String nombre;
	private CountryDTO country;
	
	
	public StateDTO() {
		super();
		setId(id);
		setNombre(nombre);
		setCountry(country);

	}

	
	public final UUID getId() {
		return id;
	}
	public final void setId(final UUID id) {
		this.id = id;
	}
	public final String getNombre() {
		return nombre;
	}
	public final void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	public final CountryDTO getCountry() {
		return country;
	}
	public final void setCountry(final CountryDTO country) {
		this.country = country;
	}

}
