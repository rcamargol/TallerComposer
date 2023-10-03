package co.edu.unbosque.model;

public class AudioException extends Exception{
	

	private static final long serialVersionUID = 1L;

	public AudioException(String mensaje, Throwable causa) {
		super (mensaje, causa);
	}

}
