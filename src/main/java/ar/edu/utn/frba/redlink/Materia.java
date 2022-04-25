package ar.edu.utn.frba.redlink;

import java.util.Collection;

public class Materia {
	private String nombreMat;
	private Collection<Materia> correlativas;
	
	public Materia(String nombreMat, Collection<Materia> correlativas) {
		super();
		this.nombreMat = nombreMat;
		this.correlativas = correlativas;
	}

	public boolean cumpleCorrelativas(Alumno unAlumno) {
		if(correlativas.isEmpty()) {
			return true;
		}else {
			return unAlumno.materiasAprob.containsAll(correlativas);
		}
		
	}
	
	public Collection<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(Collection<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public String getNombreMat() {
		return nombreMat;
	}

	public void setNombreMat(String nombreMat) {
		this.nombreMat = nombreMat;
	}
}
