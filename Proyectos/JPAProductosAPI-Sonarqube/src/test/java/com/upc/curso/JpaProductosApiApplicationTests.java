package com.upc.curso;

import com.upc.curso.entidades.Producto;
import com.upc.curso.negocio.ProductoNegocio;
import com.upc.curso.repositorio.ProductoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class JpaProductosApiApplicationTests {
	@MockBean
	private ProductoRepositorio productoRepositorio;
	@Autowired
	private ProductoNegocio productoNegocio;

	@Test
	void contextLoads() {
	}

	@Test
		void calcularPrecioVentaTest(){
			Producto producto = new Producto(1L, "Leche", 4,100);
			when(productoRepositorio.findById(1L)).thenReturn(Optional.of(producto));
			try {
				Assertions.assertEquals(4.31,productoNegocio.calcularPrecioVenta(1L),0.01);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}

}
