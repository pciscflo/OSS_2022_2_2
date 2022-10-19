package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.negocio.IProductoNegocio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoproductosApplicationTests {

	@Autowired
	private IProductoNegocio productoNegocio;

	@Test
	void contextLoads() {
	}

	@Test
	void testRegistro(){
		Producto producto = new Producto();
		producto.setDescripcion("Fanta");
		producto.setPrecio(3);
		producto.setStock(30);
		productoNegocio.registrar(producto);

	}
	@Test
	void testBuscar(){
		try {
			productoNegocio.buscar(1L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testListado(){
		List<Producto> lista;
		lista = productoNegocio.listado();
		for(Producto p:lista){
			System.out.println(p.getCodigo() + "  " + p.getDescripcion());
		}
	}

	@Test
	void testPrecioVenta(){
		try {
			double venta;
			venta = productoNegocio.calcularPrecioVenta(1L);
			System.out.println(venta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}





}
