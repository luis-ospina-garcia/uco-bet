package co.edu.uco.ucobet.generales.domain;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public class Domain {
	
	private UUID id;
	private String idAsString;
	
	protected Domain (final UUID id) {
		setId(id);
		
	}
	
	protected Domain (final String id) {
		setId(id);
		
	}

	public final UUID getId() {
		return UUIDHelper.isDefault(id)? UUIDHelper.convertToUUID(idAsString):id;
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	public final void setId(final String id) {
		this.idAsString = id;
	}
	public void generateId() {
		this.id = UUIDHelper.generate();
	}
}
