package taller02.ejercicio02.modelo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inscripcion {
	//TODO: Dentro de esta clase tenemos una enum que indica el estado posible para una inscripción
	//completar
	public enum Estado{INSCRIPTO, REGULAR, PROMOCION, LIBRE}
		
	private Instant fechaInscripcion;
	private Alumno alumno;
	private List<Evaluacion> evaluaciones = new ArrayList<>();
	

	public Instant getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(Instant fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}
	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
	
	public Estado estado() {
		Optional<Evaluacion> evalFinalOpt = this.evaluaciones.stream().filter(e -> e.getTipo().equals(TipoEvaluacion.FINAL)).findAny();
		if(evalFinalOpt.isPresent()) {
			Evaluacion evalFinal = evalFinalOpt.get();
			
			if(evalFinal.getNota().compareTo(60.0)>=0 ) {
				return Estado.PROMOCION;
			} else if (evalFinal.getNota().compareTo(20.0)>=0 ) {
				return Estado.REGULAR;
			}
			else return Estado.LIBRE;
		} else {
			return Estado.INSCRIPTO;
		}
	}
	

}
