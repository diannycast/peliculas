package com.peliculas.dao;

import com.peliculas.db.DatabaseConnection;
import com.peliculas.model.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Esta clase se conecta a la base de datos y hace las operaciones
public class PeliculaDAOimpl implements PeliculaDAO {

    // Buscar una pelicula por su id
    @Override
    public Pelicula buscarPorId(int id) {
        Pelicula pelicula = null;
        String sql = "SELECT * FROM pelicula WHERE id = ?";
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pelicula = new Pelicula();
                pelicula.setId(rs.getInt("id"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnio(rs.getInt("anio"));
                pelicula.setDuracionMin(rs.getInt("duracion_min"));
                pelicula.setVistas(rs.getInt("vistas"));
                pelicula.setIdCategoria(rs.getInt("id_categoria"));
                pelicula.setIdClasificacion(rs.getInt("id_clasificacion"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return pelicula;
    }

    // Obtener todas las peliculas ordenadas por vistas
    @Override
    public List<Pelicula> obtenerTodos() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM pelicula ORDER BY vistas DESC";
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pelicula p = new Pelicula();
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setDirector(rs.getString("director"));
                p.setAnio(rs.getInt("anio"));
                p.setDuracionMin(rs.getInt("duracion_min"));
                p.setVistas(rs.getInt("vistas"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                p.setIdClasificacion(rs.getInt("id_clasificacion"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    // Agregar una pelicula nueva
    @Override
    public void agregar(Pelicula p) {
        String sql = "INSERT INTO pelicula (titulo, director, anio, duracion_min, vistas, id_categoria, id_clasificacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setInt(3, p.getAnio());
            ps.setInt(4, p.getDuracionMin());
            ps.setInt(5, p.getVistas());
            ps.setInt(6, p.getIdCategoria());
            ps.setInt(7, p.getIdClasificacion());
            ps.executeUpdate();
            System.out.println("Pelicula agregada!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Actualizar una pelicula
    @Override
    public void actualizar(Pelicula pelicula) {
        String sql = "UPDATE pelicula SET titulo=?, director=?, anio=?, duracion_min=?, vistas=?, id_categoria=?, id_clasificacion=? WHERE id=?";
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setInt(3, pelicula.getAnio());
            ps.setInt(4, pelicula.getDuracionMin());
            ps.setInt(5, pelicula.getVistas());
            ps.setInt(6, pelicula.getIdCategoria());
            ps.setInt(7, pelicula.getIdClasificacion());
            ps.setInt(8, pelicula.getId());
            ps.executeUpdate();
            System.out.println("Pelicula actualizada!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Eliminar una pelicula
    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM pelicula WHERE id = ?";
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Pelicula eliminada!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Filtrar peliculas por rango de año y categoria
    @Override
    public List<Pelicula> filtrarPorAnioYCategoria(int anioDesde, int anioHasta, int idCategoria) {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM pelicula WHERE anio BETWEEN ? AND ? AND id_categoria = ? ORDER BY vistas DESC";
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, anioDesde);
            ps.setInt(2, anioHasta);
            ps.setInt(3, idCategoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pelicula p = new Pelicula();
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setDirector(rs.getString("director"));
                p.setAnio(rs.getInt("anio"));
                p.setDuracionMin(rs.getInt("duracion_min"));
                p.setVistas(rs.getInt("vistas"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                p.setIdClasificacion(rs.getInt("id_clasificacion"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}