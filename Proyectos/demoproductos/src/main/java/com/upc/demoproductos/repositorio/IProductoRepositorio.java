package com.upc.demoproductos.repositorio;

import com.upc.demoproductos.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepositorio extends JpaRepository<Producto,Long> {
}
