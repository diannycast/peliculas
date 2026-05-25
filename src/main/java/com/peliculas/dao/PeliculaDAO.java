package com.peliculas.dao;

import com.peliculas.model.Pelicula;
import java.util.List;

//Interfaz DAO para operaciones CRUD y filtros sobre Pelicula.

public interface PeliculaDAO {
    // CREATE
    void agregar(Pelicula pelicula);

    // READ
    Pelicula buscarPorId(int id);
    List<Pelicula> obtenerTodos();

    // UPDATE (Faltaba)
    void actualizar(Pelicula pelicula);

    // DELETE (Faltaba)
    void eliminar(int id);

    // FILTROS ADICIONALES
    List<Pelicula> filtrarPorAnioYCategoria(int anioDesde, int anioHasta, int idCategoria);
}