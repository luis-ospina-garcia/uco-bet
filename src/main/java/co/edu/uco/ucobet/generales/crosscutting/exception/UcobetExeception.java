package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

public class UcobetExeception extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String userMessage;
	private final Layer layer;
	
	
	public UcobetExeception(final String userMessage, final String technicalMessage, final Exception rootException, final Layer layer) {
		super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessage)),
				ObjectHelper.getDefault(rootException, new Exception()));
		this.userMessage = TextHelper.applyTrim(userMessage);
		this.layer = ObjectHelper.getDefault(layer, Layer.GENERAL);
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	
	public Layer getLayer() {
		return layer;
	}	

}
