package taller02.ejercicio02.modelo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import taller02.ejercicio02.excepciones.NoPuedeAsingarDocenteException;

public class Docente {

	private Integer id;
	private String nombre;
	private List<Curso> cursos =new ArrayList<>();
	
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
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	/**
	 * TODO: Asginar un docente a un curso: Un docente puede ser asignado a un curso, si y solo si, todos los 
	 * cursos donde el docente este asignado tiene al menos un 25% del porcentaje de aprobación. En 
	 * el caso de que un docente no se pueda inscribir en un curso, debe lanzar una excepción para 
	 * gestionar esta situación. Estos métodos se deben implementar en las clases, CURSO y DOCENTE.
	 */
	public void asignarCurso(Curso curso) throws NoPuedeAsingarDocenteException{
		boolean sePuedeAsignar = cursos.stream()
									   .allMatch(c -> c.porcentajeAprobacion() >= 25);
		if(sePuedeAsignar) cursos.add(curso);
		else throw new NoPuedeAsingarDocenteException("No se puede agregar el curso para el docente");
	}
	
	/**
	 * Retorna un map donde la clave es el nombre de cada curso y el valor es el promedio de todas las evaluaciones
	 * para ese curso 
	 * @param tipo
	 * @return
	 */
	public Map<String, Double> notaPromedio(TipoEvaluacion tipo){
		Map<String, Double> resultado = new LinkedHashMap<>();
		for(Curso curso: cursos) {
			OptionalDouble promedio = curso.getInscripcion().stream()
					.flatMap(i -> i.getEvaluaciones().stream())
					.filter(e -> e.getTipo().equals(tipo))
					.mapToDouble(e -> e.getNota())
					.average();
			resultado.put(curso.getNombre(), promedio.orElse(0.0));
		}
		return resultado;
	}
}
