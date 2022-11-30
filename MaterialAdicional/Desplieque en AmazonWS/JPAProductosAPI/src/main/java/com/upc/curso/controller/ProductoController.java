package com.upc.curso.controller;

import com.upc.curso.entidades.Producto;
import com.upc.curso.negocio.IProductoNegocio;
import com.upc.curso.negocio.ProductoNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ProductoController {
   @Autowired
   public IProductoNegocio negocio;
   Logger logger = LoggerFactory.getLogger(ProductoController.class);
   
   @GetMapping("/productos")
   public List<Producto>  obtenerProductos(){
	   return negocio.listado();
   }

    @GetMapping("/productosVentas")
    public List<Producto> listadoTotalConPrecioVenta(){
       List<Producto> listado =null;
       try {
           listado = negocio.listadoTotalConPrecioVenta();
       }catch(Exception e){
           logger.error("Error de consulta de ventas",e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible consultar", e);
       }
       return listado;
    }


   @PostMapping("/producto")
   public Producto crearProducto(@RequestBody Producto producto) {
       Producto p;
       try {
           logger.debug("Creando objeto");
           p = negocio.registrar(producto);
       }catch(Exception e){
           logger.error("Error de creación",e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo crear, sorry", e);
       }
	   return p;
   }

   @PutMapping("/producto")
   public Producto actualizarProducto(@RequestBody Producto productoDetalle) {
       Producto producto;
       try {
           logger.debug("Actualizando producto");
           producto = negocio.actualizarProducto(productoDetalle);
           logger.debug("Producto Actualizado");
           return producto;
       } catch (Exception e) {
           logger.error("Error de Actualización ", e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo actualizar, sorry");
       }
   }
   
   @DeleteMapping("/producto/{codigo}")
   public Producto borrarProducto(@PathVariable(value = "codigo") Long codigo){
       try {
           logger.debug("Eliminando objeto");
           return negocio.borrarProducto(codigo);
       } catch (Exception e) {
           logger.error("Error de Eliminación ", e);
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo eliminar, sorry");
       }
   }


    @GetMapping("/entidad/{codigo}")
    public Producto obtenerEntidad(@PathVariable(value = "codigo") Long codigo){
        Producto p;
        try {
            logger.debug("Buscando entidad");
            p = negocio.buscar(codigo);
        }catch(Exception e){
            logger.error("Error de Obtener Entidad");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mi mensaje");
        }
        return p;
    }
   
}
