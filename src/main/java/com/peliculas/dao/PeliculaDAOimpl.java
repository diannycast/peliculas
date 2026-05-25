package com.peliculas.dao;
import com.peliculas.db.DatabaseConnection;
import com.peliculas.model.Pelicula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// conceccion de base de datos para hacer las operaciones
public class PeliculaDAOimpl implements PeliculaDAO;
// buscar peliculas por su id
@Override
public Pelicula buscarPorId (int id){
    Pelicula pelicula = null;
    String sql = "select * from pelicula where id = ?";
    try {
        PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement();
        ps.setInt(1. id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            pelicula = new Pelicula();
            pelicula.setId(rs.getInt("id"));
            pelicula.setTitulo(rs.getString("titulo"));
        }
    }
}
