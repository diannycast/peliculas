package com.peliculas.dao;

import com.peliculas.model.Pelicula;
import java.util.List;

//Interfaz DAO y filtros sobre Pelicula.

public interface PeliculaDAO {
    // AGREGAR
    void agregar(Pelicula pelicula);

    // LEER
    Pelicula buscarPorId(int id);
    List<Pelicula> obtenerTodos();

    // ACTUALIZAR
    void actualizar(Pelicula pelicula);

    // ELIMINAR
    void eliminar(int id);

    // FILTROS ADICIONALES
    List<Pelicula> filtrarPorAnioYCategoria(int anioDesde, int anioHasta, int idCategoria);
}