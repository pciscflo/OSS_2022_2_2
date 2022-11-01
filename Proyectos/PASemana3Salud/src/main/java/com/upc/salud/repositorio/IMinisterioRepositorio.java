package com.upc.salud.repositorio;

import com.upc.salud.entidades.CentroSalud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMinisterioRepositorio extends JpaRepository<CentroSalud, Long> {
}
