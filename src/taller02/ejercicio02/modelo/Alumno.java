package taller02.ejercicio02.modelo;

import java.util.ArrayList;
import java.util.List;

import taller02.ejercicio02.excepciones.NoPuedeInscribirAlumnoException;

public class Alumno {
	private Integer id;
	private String nombre;
	private List<Inscripcion> inscripciones = new ArrayList<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}
	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
	/**
	 * Asignar un alumno a un curso: Un alumno se puede inscribir a un curso registrando un objeto 
	 * inscripción si y solo si no acumula mas de 3 inscripciones en las que el estado sea LIBRE o 
	 * REGULAR. En el caso de que un alumno no se pueda inscribir en un curso, debe lanzar una 
	 * excepción para gestionar esta situación. Estos métodos se deben implementar en las clases, 
	 * CURSO y ALUMNO.
	 */
	public void inscribir(Inscripcion i) throws NoPuedeInscribirAlumnoException{
		long cantInscripcionesLibresORegular = inscripciones.stream()
												.filter(ins -> ins.estado() == Inscripcion.Estado.LIBRE 
													|| ins.estado() == Inscripcion.Estado.REGULAR)
												.count();
		boolean sePuedeInscribir = cantInscripcionesLibresORegular <= 3;
		if(sePuedeInscribir) inscripciones.add(i);
		else throw new NoPuedeInscribirAlumnoException("El alumno no se puede inscribir");
	}

}
