package co.edu.uco.ucobet.generales.crosscutting.exception;

import co.edu.uco.ucobet.generales.crosscutting.exception.enums.Layer;

public class RepositoryUcobetException extends UcobetExeception {

	private static final long serialVersionUID = 1L;

	public RepositoryUcobetException(String userMessage, String technicalMessage, Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.REPOSITORY);
	}
	
	public static final RepositoryUcobetException create(final String userMessage, final String technicalMessage, final Exception rootException){
		return new RepositoryUcobetException(userMessage,technicalMessage,rootException);
	}

	public static final RepositoryUcobetException create(final String userMessage){
		return new RepositoryUcobetException(userMessage,userMessage, new Exception());
	}

	public static final RepositoryUcobetException create(final String userMessage, final String technicalMessage){
		return new RepositoryUcobetException(userMessage,technicalMessage,new Exception());
	}
	
	public static final RepositoryUcobetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new RepositoryUcobetException(userMessage, userMessage, rootException);
		
	}
}




