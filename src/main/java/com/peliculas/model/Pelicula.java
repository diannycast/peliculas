// Clase para guardar las peliculas
package com.peliculas.model;
public class Pelicula {

    // Variables de la pelicula
    private int id;
    private String titulo;
    private String director;
    private int anio;
    private int duracionMin;
    private int vistas;
    private int idCategoria;
    private int idClasificacion;

    // Constructor vacio
    public Pelicula() {
    }

    // Constructor con parametros
    public Pelicula(int nuevoId, String nuevoTitulo, String nuevoDirector,
                    int nuevoAnio, int nuevosMinutos, int nuevasVistas,
                    int nuevaCategoria, int nuevaClasificacion) {
        id = nuevoId;
        titulo = nuevoTitulo;
        director = nuevoDirector;
        anio = nuevoAnio;
        duracionMin = nuevosMinutos;
        vistas = nuevasVistas;
        idCategoria = nuevaCategoria;
        idClasificacion = nuevaClasificacion;
    }

    // Metodos get y set
    public int getId() {
        return id;
    }

    public void setId(int nuevoId) {
        id = nuevoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String nuevoTitulo) {
        titulo = nuevoTitulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String nuevoDirector) {
        director = nuevoDirector;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int nuevoAnio) {
        anio = nuevoAnio;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int nuevosMinutos) {
        duracionMin = nuevosMinutos;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int nuevasVistas) {
        vistas = nuevasVistas;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int nuevaCategoria) {
        idCategoria = nuevaCategoria;
    }

    public int getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(int nuevaClasificacion) {
        idClasificacion = nuevaClasificacion;
    }

    // Metodo para imprimir
    public String toString() {
        return "[" + id + "] " + titulo + " (" + anio + ") | Dir: " + director + " | " + duracionMin + " min | Vistas: " + vistas + " | CatID: " + idCategoria + " | ClasifID: " + idClasificacion;
    }
}
