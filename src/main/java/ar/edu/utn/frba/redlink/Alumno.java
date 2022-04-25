package ar.edu.utn.frba.redlink;

import java.util.Collection;

public class Alumno {
		String nombre;
		Collection<Materia> materiasAprob;
		
		
		public Alumno(String nombre, Collection<Materia> materiasAprob) {
			super();
			this.nombre = nombre;
			this.materiasAprob = materiasAprob;
		}


		public void inscribirmeCurso(Curso unCurso) {
				unCurso.aceptarAlumno(this);
		}
}


//Tests a hacer:
//	Insripcion ok
//	Falta Correlativa
//	Abre el curso correctamente
//	No abre el curso correctamente