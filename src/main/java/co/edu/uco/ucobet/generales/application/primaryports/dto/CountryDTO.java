package co.edu.uco.ucobet.generales.application.primaryports.dto;

import java.util.UUID;

public class CountryDTO {
	
	private UUID  id;
	private String nombre;
	
	public CountryDTO() {
		super();
		setId(id);
		setNombre(nombre);
	}
	
	
	public final  UUID getId() {
		return id;
	}
	public final  void setId(final UUID id) {
		this.id = id;
	}
	public final String getNombre() {
		return nombre;
	}
	public final  void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	
}
