package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.repositorio.IProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
        double igv = 0;
        if(producto!=null){
            igv = 0.18*producto.getPrecio();
        }
        return igv;
    }

    @Override
    public double calcularDescuento(Producto producto) {
        double descuento =0;
        if(producto!=null){
            if(producto.getStock()>20){
                descuento = 0.10*producto.getPrecio();
            }
        }
        return descuento;
    }

    @Override
    public double calcularPrecioVenta(Producto producto) {
        return producto.getPrecio() + calcularIGV(producto) - calcularDescuento(producto);
    }

    @Override
    public double calcularPrecioVenta(Long codigo) throws Exception {
        Producto producto = buscar(codigo);
        return calcularPrecioVenta(producto);
    }
}
