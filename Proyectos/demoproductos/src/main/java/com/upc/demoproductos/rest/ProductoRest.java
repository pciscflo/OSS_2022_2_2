package com.upc.demoproductos.rest;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.negocio.IProductoNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoRest {
    @Autowired
    private IProductoNegocio productoNegocio;
    Logger logger = LoggerFactory.getLogger(ProductoRest.class);

    @GetMapping("/productos")
    public List<Producto> lista(){
        return productoNegocio.listado();
    }
    @GetMapping("/productosTotal")
    public List<Producto> listadoTotal(){
        return productoNegocio.listadoTotal();
    }
    @GetMapping("/productosDescripcion/{descripcion}")
    public List<Producto> listadoPorDescricpion(@PathVariable(value = "descripcion") String
                                                descripcion){
        return productoNegocio.listadoProductosPorDescripcion(descripcion);
    }
    @PostMapping("/producto")
    public Producto registrar(@RequestBody Producto producto){
         Producto p;
         try {
             p = productoNegocio.registrar(producto);
         }catch (Exception e){
             logger.error("Error en registro", e);
             throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede",e);
         }
         return p;
    }
    @GetMapping("producto/{codigo}")
    public Producto buscar(@PathVariable(value = "codigo") Long codigo){
        try {
            return productoNegocio.buscar(codigo);
        } catch (Exception e) {
            logger.error("Error critico:",e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe",e);
        }
    }



}
