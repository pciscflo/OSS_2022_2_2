package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.negocio.IProductoNegocio;
import com.upc.demoproductos.repositorio.IProductoRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductoPruebaUnitaria {
    @Autowired
    private IProductoNegocio productoNegocio;
    @MockBean
    private IProductoRepositorio productoRepositorio;

    @Test
    void testCalcularPrecioVenta(){
        Producto producto = new Producto(1L, "Fanta", 3, 30);
        when(productoRepositorio.findById(1L)).thenReturn(Optional.of(producto));
        try {
            Assertions.assertEquals(3.24,productoNegocio.calcularPrecioVenta(1L), 0.01);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testListado(){
        when(productoRepositorio.findAll()).thenReturn(
                Stream.of(
                        new Producto(1L, "Fanta", 3, 30),
                        new Producto(2L, "Coca Cola", 4, 50)).
                                collect(Collectors.toList()));
        Assertions.assertEquals(2, productoNegocio.listado().size());
    }

}
