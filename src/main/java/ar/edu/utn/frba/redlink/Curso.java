package ar.edu.utn.frba.redlink;

import java.util.ArrayList;
import java.util.Collection;

public class Curso {
	private final int alumnosReq;
	Collection<Alumno> inscriptos;
	private boolean estaAbierto;
	
	public boolean isEstaAbierto() {
		return estaAbierto;
	}
	
	private Materia materiaCurso;
	//TODO: Agregar Correlativas
	

	public void aceptarAlumno(Alumno unAlumno){
		if(materiaCurso.cumpleCorrelativas(unAlumno)) {
			inscriptos.add(unAlumno);
		}
	}
	
	public void abrirCurso() {
		if(alumnosReq <= inscriptos.size() && !estaAbierto) {
			this.estaAbierto = true;
		}
	}
	public Curso(int alumnosReq, Materia miMateria) {
		super();
		this.alumnosReq = alumnosReq;
		this.materiaCurso = miMateria;
		this.inscriptos = new ArrayList<Alumno>();
		this.estaAbierto = false;
	}
}
