package com.upc.curso.negocio;

import com.upc.curso.entidades.Producto;
import com.upc.curso.entidades.ProductoDTO;
import com.upc.curso.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //no agnostica
public class ProductoNegocio {
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Transactional
    public Producto registrar(ProductoDTO producto){
       Producto producto1 = new Producto();
       producto1.setDescripcion(producto.getDescripcion());
       producto1.setPrecio(producto.getPrecio());
       producto1.setStock(producto.getStock());
       return productoRepositorio.save(producto1);
    }
    public Producto buscar(Long codigo) throws Exception {
        return productoRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontró entidad"));
    }
    public List<Producto> listado(){
        return productoRepositorio.findAll();
    }
    public List<Producto> listadoTotalConPrecioVenta(){
        List<Producto> listado = productoRepositorio.findAll();
        for(Producto p: listado){
            p.setTotal(calcularPrecioVenta(p));
        }
        return listado;
    }

    public double calcularIGV(Producto producto){
        double igv=0;
        if (producto!=null){
            igv = 0.18*producto.getPrecio();
        }
        return igv;
    }
    public double calcularDescuento(Producto producto) {
        double descuento = 0;
        if (producto!=null) {
            if (producto.getStock() > 20) {
                descuento = 0.1 * producto.getPrecio();
            }
        }
        return descuento;
    }

    public  double calcularPrecioVenta(Producto producto){
        return calcularIGV(producto) + producto.getPrecio() - calcularDescuento(producto);
    }

    public List<Producto> obtenerReportePorDescripcion(String prefijo){
        return productoRepositorio.obtenerReportePorDescripcion(prefijo);
        //return productoRepositorio.findByDescripcionStartingWith(prefijo);
    }
    public List<Producto> listadorxPrecioMenor(double precio){
       //return productoRepositorio.listadoxPrecioMenor(precio);
       return productoRepositorio.findByPrecioIsLessThan(precio);
    }

    public Producto actualizarProducto(Producto producto) throws Exception {
        productoRepositorio.findById(producto.getCodigo()).orElseThrow(() -> new Exception("No se encontró entidad"));
        return productoRepositorio.save(producto);
    }

    public double calcularPrecioVenta(Long codigo) throws Exception {
        Producto producto;
        producto = buscar(codigo);
        return calcularPrecioVenta(producto);
    }

    public Producto borrarProducto(Long codigo) throws Exception{
        Producto producto = productoRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontró entidad"));
        productoRepositorio.delete(producto);
        return producto;
    }

}
