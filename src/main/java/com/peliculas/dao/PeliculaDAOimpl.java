package com.peliculas.dao;

import com.peliculas.db.DatabaseConnection;
import com.peliculas.model.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// coneccion basde de datos para pelicula
public class PeliculaDAOimpl implements PeliculaDAO {

    // pelicula por su id
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
    //orden de peliculas por vistas
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
        }
}
}