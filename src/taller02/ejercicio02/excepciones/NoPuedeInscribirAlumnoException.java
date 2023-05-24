package taller02.ejercicio02.excepciones;

public class NoPuedeInscribirAlumnoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoPuedeInscribirAlumnoException(String msg) {
		super(msg);
	}
}