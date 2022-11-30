package com.upc.curso.negocio;

import com.upc.curso.entidades.Producto;

import java.util.List;

public interface IProductoNegocio {
    public Producto registrar(Producto producto);
    public Producto buscar(Long codigo) throws Exception;
    public List<Producto> listado();
    public List<Producto> listadoTotalConPrecioVenta();
    public double calcularIGV(Producto producto);
    public double calcularDescuento(Producto producto);

    public  double calcularPrecioVenta(Producto producto);

    public List<Producto> obtenerReportePorDescripcion(String prefijo);
    public List<Producto> listadorxPrecioMenor(double precio);

    public Producto actualizarProducto(Producto producto) throws Exception;

    public double calcularPrecioVenta(Long codigo) throws Exception ;

    public Producto borrarProducto(Long codigo) throws Exception;
}
