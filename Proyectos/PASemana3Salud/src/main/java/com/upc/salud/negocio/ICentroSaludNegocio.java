package com.upc.salud.negocio;

import com.upc.salud.entidades.CentroSalud;

import java.util.List;

public interface ICentroSaludNegocio {
    public CentroSalud registrar(CentroSalud centroSalud);
    public List<CentroSalud> listar();
    public List<CentroSalud> listarConCalificaciones();
    public CentroSalud buscar(Long codigo) throws Exception;
    public List<CentroSalud> listarPorTipo(String tipo);
    public CentroSalud actualizar(CentroSalud centroSalud) throws Exception;
    public CentroSalud actualizarCentroSalud(Long codigo, String nombre);
    public double calcularCalificacion(CentroSalud centroSalud);
    public String obtenerResultadoFinal(CentroSalud centroSalud);
    public String obtenerResultadoFinal(Long codigo) throws Exception;
}
