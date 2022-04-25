package ar.edu.utn.frba.redlink;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

public class AlumnoTest {
	
	Materia analisis1 = new Materia("Analisis 1", Collections.<Materia>emptyList());
	Materia algebra = new Materia("Algebra", Collections.<Materia>emptyList());
	ArrayList<Materia> correlativasAM2 = new ArrayList<Materia>();
	Materia analisis2 = new Materia("Analisis 2", correlativasAM2);
	
	Alumno juan = new Alumno("Juan", Collections.<Materia>emptyList());
	Alumno luna = new Alumno("Luna", correlativasAM2);
	
	Curso cursoAM2TM = new Curso(1, analisis2);
	Curso cursoAlgebraTM = new Curso(1, algebra);
	Curso cursoAM2TT = new Curso(3, analisis2);
	@Before
	public void init() {
		correlativasAM2.add(analisis1);
		correlativasAM2.add(algebra);
	}
	
	
	
	@Test
	public void aptoInscripcion() {
		juan.inscribirmeCurso(cursoAlgebraTM);
		assert(cursoAlgebraTM.inscriptos.contains(juan));
	}
	
	@Test
	public void aptoInscripcionConCorr() {
		luna.inscribirmeCurso(cursoAM2TM);
		assert(cursoAM2TM.inscriptos.contains(luna));
	}
	
	@Test
	public void noAptoInscripcion() {
		juan.inscribirmeCurso(cursoAM2TM);
		assert(!cursoAM2TM.inscriptos.contains(juan));
	}

	
	@Test
	public void cursoApto() {
		juan.inscribirmeCurso(cursoAlgebraTM);
		cursoAlgebraTM.abrirCurso();
		assert(cursoAlgebraTM.isEstaAbierto());
	}
	
	@Test
	public void cursoNoApto() {
		luna.inscribirmeCurso(cursoAM2TT);
		cursoAM2TT.abrirCurso();
		assert(!cursoAM2TT.isEstaAbierto());
	}

}
