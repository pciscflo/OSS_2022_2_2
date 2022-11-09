package com.upc.curso.entidades;

import lombok.Data;

@Data
public class ProductoDTO { //POJO

    private Long codigo;
    private String descripcion;
    private double precio;
    private int stock;
    private transient double total;

}
