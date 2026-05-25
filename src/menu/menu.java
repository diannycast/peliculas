package com.peliculas.menu;

import com.peliculas.dao.PeliculaDAO;
import com.peliculas.dao.PeliculaDAOimpl;
import com.peliculas.model.Pelicula;
import java.util.List;
import java.util.Scanner;

public class Menu {

    // creo el dao y el scanner para leer lo que escribe el usuario
    PeliculaDAO dao = new PeliculaDAOimpl();
    Scanner scanner = new Scanner(System.in);

    public void iniciar() {

        int opcion = 0;

        // el menu se repite hasta que el usuario escriba 0
        while (opcion != 0) {

            System.out.println(" ");
            System.out.println("=== MENU DE PELICULAS ===");
            System.out.println("1 - Buscar pelicula por ID");
            System.out.println("2 - Ver todas las peliculas");
            System.out.println("3 - Agregar una pelicula");
            System.out.println("4 - Filtrar por anio y categoria");
            System.out.println("0 - Salir");
            System.out.print("Escribe una opcion: ");

            opcion = scanner.nextInt();

            // dependiendo de lo que escribio el usuario llamo al metodo
            if (opcion == 1) {
                buscarPorId();
            }
            if (opcion == 2) {
                verTodas();
            }
            if (opcion == 3) {
                agregar();
            }
            if (opcion == 4) {
                filtrar();
            }
            if (opcion == 0) {
                System.out.println("Chao pues :*");
            }
        }
    }
    public void buscarPorId() {
        System.out.print("Escribe el ID de la pelicula: ");
        int id = scanner.nextInt();

        Pelicula resultado = dao.buscarPorId(id);

        if (resultado != null) {
            System.out.println("Pelicula encontrada: ");
            System.out.println(resultado);
        } else {
            System.out.println("No existe una pelicula con ese ID");
        }
    }
    public void verTodas() {
        List<Pelicula> lista = dao.obtenerTodos();

        System.out.println("Lista de peliculas ordenadas por vistas:");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

