package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.negocio.IProductoNegocio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest // Es test de prueba de logica del developer, no es unitaria
class DemoproductosApplicationTests {

	@Autowired
	private IProductoNegocio productoNegocio;

	@Test
	void contextLoads() {
	}

	@Test
	void testRegistro(){
		Producto producto = new Producto();
		producto.setDescripcion("Coca Cola");
		producto.setPrecio(4);
		producto.setStock(40);
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
    @Test
	void testActualizar(){
		Producto producto = new Producto();
		producto.setCodigo(1L);
		producto.setPrecio(2);
		producto.setDescripcion("Sprite");
		producto.setStock(100);
		try {
			productoNegocio.actualizar(producto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	@Test
	void testListadoDescripcion(){
		List<Producto> listado;
		listado = productoNegocio.listadoProductosPorDescripcion("Spri");
		for (Producto producto:listado){
			System.out.println(producto.getCodigo() + "  " + producto.getDescripcion());
		}
	}
	@Test
	void testListadoTotal(){
		List<Producto> listado;
		listado = productoNegocio.listadoTotal();
		for (Producto producto:listado){
			System.out.println(producto.getCodigo() + "  " + producto.getDescripcion() + "  " +
					producto.getTotal());
		}
	}




}
