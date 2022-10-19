package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.repositorio.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoNegocio implements IProductoNegocio{

    @Autowired
    IProductoRepositorio iProductoRepositorio;

    @Override
    public Producto registrar(Producto producto) {
        return iProductoRepositorio.save(producto);//insert into...
    }

    @Override
    public Producto buscar(Long codigo) throws Exception {
        return iProductoRepositorio.findById(codigo).orElseThrow(
                () -> new Exception("No se encontró entidad"));
    }

    @Override
    public List<Producto> listado() {
        return iProductoRepositorio.findAll();
    }

    @Override
    public Producto actualizar(Producto producto) throws Exception {
        buscar(producto.getCodigo());
        return iProductoRepositorio.save(producto);
    }

    @Override
    public double calcularIGV(Producto producto) {
        return 0;
    }

    @Override
    public double calcularDescuento(Producto producto) {
        return 0;
    }

    @Override
    public double calcularPrecioVenta(Producto producto) {
        return 0;
    }

    @Override
    public double calcularPrecioVenta(Long codigo) {
        return 0;
    }
}
