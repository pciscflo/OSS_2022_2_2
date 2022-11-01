package com.upc.salud.negocio;

import com.upc.salud.entidades.CentroSalud;
import com.upc.salud.repositorio.IMinisterioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CentroSaludNegocio implements  ICentroSaludNegocio{

    @Autowired
    IMinisterioRepositorio _ministerioRepositorio;

    @Override
    public CentroSalud registrar(CentroSalud centroSalud) {
        return _ministerioRepositorio.save(centroSalud);
    }

    @Override
    public List<CentroSalud> listar() {
        return _ministerioRepositorio.findAll();
    }

    @Override
    public List<CentroSalud> listarConCalificaciones() {
        List<CentroSalud> listado;
        listado = _ministerioRepositorio.findAll();

        for (CentroSalud centroSalud:listado) {
            centroSalud.setCalificacion(calcularCalificacion(centroSalud));
        }
        return listado;
    }

    @Override
    public CentroSalud buscar(Long codigo) throws Exception {
        return _ministerioRepositorio.findById(codigo).orElseThrow(() -> new Exception("No se encontro Ministerio"));
    }

    @Override
    public List<CentroSalud> listarPorTipo(String tipo) {
        List<CentroSalud> listado;
        listado = _ministerioRepositorio.findAll();
        var listadoFiltrado = new ArrayList<CentroSalud>();

        for (CentroSalud centroSalud:listado) {
            if (centroSalud.getTipo().contains(tipo)) {
                listadoFiltrado.add(centroSalud);
            }
        }
        return listadoFiltrado;
    }

    @Override
    public CentroSalud actualizar(CentroSalud centroSalud) throws Exception {
        buscar(centroSalud.getCodigo());
        return _ministerioRepositorio.save(centroSalud);
    }

    @Override
    public CentroSalud actualizarCentroSalud(Long codigo, String nombre) {
        var centroSalud = _ministerioRepositorio.findById(codigo);
        centroSalud.get().setNombre(nombre);

        return _ministerioRepositorio.save(centroSalud.get());
    }

    @Override
    public double calcularCalificacion(CentroSalud centroSalud) {
        return centroSalud.getCalificacionInfraestructura() * 0.35 + centroSalud.getCalificacionServicios() * 0.65;
    }

    @Override
    public String obtenerResultadoFinal(CentroSalud centroSalud) {
        double calificacion = calcularCalificacion(centroSalud);
        return calificacion >= 80 ? "APROBADO" : "RECHAZADO";
    }

    public String obtenerResultadoFinal(Long codigo) throws Exception {
        CentroSalud centroSalud = buscar(codigo);
        return obtenerResultadoFinal(centroSalud);
    }
}
