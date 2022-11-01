package com.upc.salud;

import com.upc.salud.entidades.CentroSalud;
import com.upc.salud.negocio.ICentroSaludNegocio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaludApplicationTests {

	@Autowired
	private ICentroSaludNegocio centroSaludNegocio;

	@Test
	void testRegistrarCentroSalud(){
		for (int i = 0; i < 4; i++) {
			var centroSalud = new CentroSalud();
			centroSalud.setNombre("GRAU");
			centroSalud.setTipo("HOSPITAL");
			centroSalud.setCalificacionInfraestructura(60);
			centroSalud.setCalificacionServicios(50);
			centroSalud.setAmbulancias(false);
			centroSaludNegocio.registrar(centroSalud);
		}
	}

	@Test
	void testActualizarCentroSalud(){
		CentroSalud centroSalud = new CentroSalud();
		centroSalud.setCodigo(1L);
		centroSalud.setNombre("ALMENARA");
		centroSalud.setTipo("CLINICA");
		centroSalud.setCalificacionInfraestructura(50);
		centroSalud.setCalificacionServicios(46);
		centroSalud.setAmbulancias(true);
		try {
			centroSaludNegocio.actualizar(centroSalud);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
