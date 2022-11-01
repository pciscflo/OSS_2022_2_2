package com.upc.salud.entidades;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CENTROSALUD")
public class CentroSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "calificacionInfraestructura")
    private int calificacionInfraestructura;

    @Column(name = "calificacionServicios")
    private int calificacionServicios;

    @Column(name = "ambulancias")
    private boolean ambulancias;

    private transient double calificacion;

    public CentroSalud() {
    }

    @Override
    public String toString() {
        return this.getCodigo() + "  " + this.getNombre() + "  " + this.getCalificacion();
    }

    public CentroSalud(Long codigo, String nombre, String tipo, int calificacionInfraestructura, int calificacionServicios, boolean ambulancias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.calificacionInfraestructura = calificacionInfraestructura;
        this.calificacionServicios = calificacionServicios;
        this.ambulancias = ambulancias;
    }
}
