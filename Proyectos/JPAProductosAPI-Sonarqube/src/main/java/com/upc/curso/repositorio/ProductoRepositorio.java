package com.upc.curso.repositorio;

import com.upc.curso.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE p.descripcion like %:prefijo%")
    public List<Producto> obtenerReportePorDescripcion(@Param("prefijo") String prefijo);
    public List<Producto> findByDescripcionStartingWith(String prefix);
    @Query("SELECT p FROM Producto p WHERE p.precio<=:xprecio")
    public List<Producto> listadoxPrecioMenor(@Param("xprecio") double xprecio);
    public List<Producto> findByPrecioIsLessThan(double precio);
}
