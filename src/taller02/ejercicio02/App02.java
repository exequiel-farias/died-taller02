package taller02.ejercicio02;

import java.util.ArrayList;
import java.util.List;

import taller02.ejercicio02.excepciones.NoPuedeAsingarDocenteException;
import taller02.ejercicio02.excepciones.NoPuedeInscribirAlumnoException;
import taller02.ejercicio02.modelo.Alumno;
import taller02.ejercicio02.modelo.Curso;
import taller02.ejercicio02.modelo.Docente;
import taller02.ejercicio02.modelo.Evaluacion;
import taller02.ejercicio02.modelo.Inscripcion;
import taller02.ejercicio02.modelo.TipoEvaluacion;

public class App02 {
	// TODO: Crear en la clase App02 las instancias necesarias para probar los 3 items anteriores y el manejo de excepciones apropiado
	public static void main(String[] args) {
		Curso c1 = new Curso(1, "AM1");
		Curso c2 = new Curso(2, "Algebra");
		Curso c3 = new Curso(3, "Fisica");
		Curso c4 = new Curso(4, "DIED");
		Curso c5 = new Curso(5, "Comunicaciones");
		
		//Asignar curso a un docente por primera vez
		Docente d1 = new Docente();
		d1.setNombre("Martin");
		try {
			d1.asignarCurso(c4);
		} catch (NoPuedeAsingarDocenteException e) {
			System.out.println(e.getMessage());
		}
		Docente d2 = new Docente();
		d2.setNombre("Gabriel");
		try {
			d2.asignarCurso(c1);
		} catch (NoPuedeAsingarDocenteException e) {
			System.out.println(e.getMessage());
		}
		
		//Asignar un alumno a un curso por primera vez
		Alumno a1 = new Alumno();
		a1.setNombre("Federico");
		Evaluacion e1 = new Evaluacion();
		e1.setNota(65.0);
		e1.setTipo(TipoEvaluacion.FINAL);
		Inscripcion i1 = new Inscripcion();
		try {
			a1.inscribir(i1);
			i1.setAlumno(a1);
			System.out.println("El alumno "+a1.getNombre()+" se pudo inscribir a "+c4.getNombre());
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		List<Evaluacion> lista1 = new ArrayList<Evaluacion>();
		lista1.add(e1);
		e1.setInscripcion(i1);
		i1.setEvaluaciones(lista1);
		
		Evaluacion e5 = new Evaluacion();
		e5.setNota(40.0);
		e5.setTipo(TipoEvaluacion.FINAL);
		Inscripcion i5 = new Inscripcion();
		try {
			a1.inscribir(i5);
			i5.setAlumno(a1);
			System.out.println("El alumno "+a1.getNombre()+" se pudo inscribir a "+c1.getNombre());
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		List<Evaluacion> lista5 = new ArrayList<Evaluacion>();
		lista5.add(e5);
		e5.setInscripcion(i5);
		i5.setEvaluaciones(lista5);
		List<Inscripcion> inscripciones5 = new ArrayList<Inscripcion>();
		inscripciones5.add(i5);
		c1.setInscripcion(inscripciones5);
		
		Alumno a2 = new Alumno();
		a2.setNombre("Camila");
		Evaluacion e2 = new Evaluacion();
		e2.setNota(62.0);
		e2.setTipo(TipoEvaluacion.FINAL);
		Inscripcion i2 = new Inscripcion();
		try {
			a2.inscribir(i2);
			i2.setAlumno(a2);
			System.out.println("El alumno "+a2.getNombre()+" se pudo inscribir a "+c4.getNombre());
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		List<Evaluacion> lista2 = new ArrayList<Evaluacion>();
		lista2.add(e2);
		e2.setInscripcion(i2);
		i2.setEvaluaciones(lista2);
		
		Alumno a3 = new Alumno();
		a3.setNombre("Yamil");
		Evaluacion e3 = new Evaluacion();
		e3.setNota(50.0);
		e3.setTipo(TipoEvaluacion.FINAL);
		Inscripcion i3 = new Inscripcion();
		try {
			a3.inscribir(i3);
			i3.setAlumno(a3);
			System.out.println("El alumno "+a3.getNombre()+" se pudo inscribir a "+c4.getNombre());
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		List<Evaluacion> lista3 = new ArrayList<Evaluacion>();
		lista3.add(e3);
		e3.setInscripcion(i3);
		i3.setEvaluaciones(lista3);
		
		Alumno a4 = new Alumno();
		a4.setNombre("Leo");
		Evaluacion e4 = new Evaluacion();
		e4.setNota(15.0);//Desaprobo DIED
		e4.setTipo(TipoEvaluacion.FINAL);
		Evaluacion e6 = new Evaluacion();
		e6.setNota(15.0);//Desaprobo AM1
		e6.setTipo(TipoEvaluacion.FINAL);
		Evaluacion e7 = new Evaluacion();
		e7.setNota(15.0);//Desaprobo Algebra
		e7.setTipo(TipoEvaluacion.FINAL);
		Evaluacion e8 = new Evaluacion();
		e8.setNota(15.0);//Desaprobo Fisica
		e8.setTipo(TipoEvaluacion.FINAL);
		Inscripcion i4 = new Inscripcion();
		try {
			a4.inscribir(i4);
			i4.setAlumno(a4);
			System.out.println("El alumno "+a4.getNombre()+" se pudo inscribir a "+c4.getNombre());
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		List<Evaluacion> lista4 = new ArrayList<Evaluacion>();
		lista4.add(e4);
		e4.setInscripcion(i4);
		i4.setEvaluaciones(lista4);
		Inscripcion i6 = new Inscripcion();
		try {
			a4.inscribir(i6);
			i6.setAlumno(a4);
			System.out.println("El alumno "+a4.getNombre()+" se pudo inscribir a "+c1.getNombre());
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		List<Evaluacion> lista6 = new ArrayList<Evaluacion>();
		lista6.add(e6);
		e6.setInscripcion(i6);
		i6.setEvaluaciones(lista6);
		Inscripcion i7 = new Inscripcion();
		try {
			a4.inscribir(i7);
			i7.setAlumno(a4);
			System.out.println("El alumno "+a4.getNombre()+" se pudo inscribir a "+c2.getNombre());
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		List<Evaluacion> lista7 = new ArrayList<Evaluacion>();
		lista7.add(e7);
		e7.setInscripcion(i7);
		i7.setEvaluaciones(lista7);
		Inscripcion i8 = new Inscripcion();
		try {
			a4.inscribir(i8);
			i8.setAlumno(a4);
			System.out.println("El alumno "+a4.getNombre()+" se pudo inscribir a "+c3.getNombre());
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		List<Evaluacion> lista8 = new ArrayList<Evaluacion>();
		lista8.add(e8);
		e8.setInscripcion(i8);
		i8.setEvaluaciones(lista8);
		
		List<Inscripcion> inscripciones2 = new ArrayList<Inscripcion>();
		inscripciones2.add(i6);
		c1.setInscripcion(inscripciones2);
		List<Inscripcion> inscripciones3 = new ArrayList<Inscripcion>();
		inscripciones3.add(i7);
		c1.setInscripcion(inscripciones2);
		List<Inscripcion> inscripciones4 = new ArrayList<Inscripcion>();
		inscripciones4.add(i8);
		c1.setInscripcion(inscripciones3);
		
		List<Inscripcion> inscripciones1 = new ArrayList<Inscripcion>();
		inscripciones1.add(i1);
		inscripciones1.add(i2);
		inscripciones1.add(i3);
		inscripciones1.add(i4);
		c4.setInscripcion(inscripciones1);
		
		System.out.println("El porcentaje de aprobacion del curso DIED "+c4.porcentajeAprobacion()+"%");
		
		try {
			d1.asignarCurso(c3);
			System.out.println("Se pudo asignar el curso "+c3.getNombre()+" al docente "+d1.getNombre());
		} catch (NoPuedeAsingarDocenteException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("El porcentaje de aprobacion del curso AM1 "+c1.porcentajeAprobacion()+"%");
		
		//El docente no se puede asignar a un curso
		try {
			d2.asignarCurso(c2);
			System.out.println("Se pudo asignar el curso "+c2.getNombre()+" al docente "+d2.getNombre());
		} catch (NoPuedeAsingarDocenteException e) {
			System.out.println(e.getMessage());
		}
		
		//El alumno no se puede inscribir a un curso
		Inscripcion i9 = new Inscripcion();
		try {
			a4.inscribir(i9);
			i9.setAlumno(a4);
			System.out.println("El alumno "+a4.getNombre()+" se pudo inscribir a "+c5.getNombre());
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		
		// completar ejercicios opcionales
		ejercicioOpcional1();
		ejercicioOpcional2();
	}
	
	public static void ejercicioOpcional1() {
		Curso c = new Curso(10,"Matematica");
		Alumno a1 = new Alumno();
		a1.setNombre("Leo");
		Alumno a2 = new Alumno();
		a2.setNombre("Carolina");
		Alumno a3 = new Alumno();
		a3.setNombre("Hector");
		Alumno a4 = new Alumno();
		a4.setNombre("Araceli");
		Evaluacion e1 = new Evaluacion();
		e1.setNota(65.0);
		e1.setTipo(TipoEvaluacion.FINAL);
		Evaluacion e2 = new Evaluacion();
		e2.setNota(65.0);
		e2.setTipo(TipoEvaluacion.FINAL);
		Evaluacion e3 = new Evaluacion();
		e3.setNota(65.0);
		e3.setTipo(TipoEvaluacion.FINAL);
		Evaluacion e4 = new Evaluacion();
		e4.setNota(50.0);
		e4.setTipo(TipoEvaluacion.FINAL);
		Inscripcion i1 = new Inscripcion();
		Inscripcion i2 = new Inscripcion();
		Inscripcion i3 = new Inscripcion();
		Inscripcion i4 = new Inscripcion();
		try {
			a1.inscribir(i1);
			i1.setAlumno(a1);
			a2.inscribir(i2);
			i2.setAlumno(a2);
			a3.inscribir(i3);
			i3.setAlumno(a3);
			a4.inscribir(i4);
			i4.setAlumno(a4);
		} catch (NoPuedeInscribirAlumnoException e) {
			System.out.println(e.getMessage());
		}
		List<Evaluacion> lista1 = new ArrayList<Evaluacion>();
		lista1.add(e1);
		e1.setInscripcion(i1);
		i1.setEvaluaciones(lista1);
		List<Evaluacion> lista2 = new ArrayList<Evaluacion>();
		lista2.add(e2);
		e2.setInscripcion(i2);
		i2.setEvaluaciones(lista2);
		List<Evaluacion> lista3 = new ArrayList<Evaluacion>();
		lista3.add(e3);
		e3.setInscripcion(i3);
		i3.setEvaluaciones(lista3);
		List<Evaluacion> lista4 = new ArrayList<Evaluacion>();
		lista4.add(e4);
		e4.setInscripcion(i4);
		i4.setEvaluaciones(lista4);
		
		List<Inscripcion> inscripciones1 = new ArrayList<Inscripcion>();
		inscripciones1.add(i1);
		inscripciones1.add(i2);
		inscripciones1.add(i3);
		inscripciones1.add(i4);
		c.setInscripcion(inscripciones1);
		
		List<String> aprobados = c.imprimirAlumnos(Inscripcion.Estado.PROMOCION);
		System.out.println("Alumnos aprobados del curso "+c.getNombre());
		for(String s : aprobados) {
			System.out.println(s);
		}
	}
	
	public static void ejercicioOpcional2() {
		//Lo implementaron los profesores
	}

}
