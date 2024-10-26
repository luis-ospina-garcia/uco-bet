package co.edu.uco.ucobet.generales.application.primaryports.dto;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public class RegisterNewCityDTO {
	
	private String cityName;
	private UUID stateId;
	
	public RegisterNewCityDTO(final String cityName,final  UUID stateId) {
		setCityName(cityName);
		setStateId(stateId);
	}
	
	public static RegisterNewCityDTO create(final String cityName,final  UUID stateId) {
		return new RegisterNewCityDTO(cityName,stateId);
	}

	public String getCityName() {
		return cityName;
	}

	private void setCityName(final String cityName) {
		this.cityName = TextHelper.applyTrim(cityName);
	}

	public UUID getStateId() {
		return stateId;
	}

	private void setStateId(final UUID stateId) {
		this.stateId = UUIDHelper.getDefault(stateId, UUIDHelper.getDefault());
		
	}
	
}
