package co.edu.uco.ucobet.generales.application.primaryports.dto;

import java.util.UUID;

public class CityDTO {
	
	private UUID id;
	private String nombre;
	private StateDTO State;
	public UUID getId() {
		return id;
	}
	
	public CityDTO() {
		setId(id);
		setNombre(nombre);
		setState(State);
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
	public final StateDTO getState() {
		return State;
	}
	public final  void setState(final StateDTO state) {
		State = state;
	}
	

}
