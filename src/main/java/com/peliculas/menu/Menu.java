package com.peliculas.menu;

import com.peliculas.dao.PeliculaDAO;
import com.peliculas.dao.PeliculaDAOimpl;
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
                System.out.println("Hasta luego!");
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

    public void agregar() {
        scanner.nextLine();

        System.out.print("Titulo de la pelicula: ");
        String titulo = scanner.nextLine();

        System.out.print("Director: ");
        String director = scanner.nextLine();

        System.out.print("Anio de lanzamiento: ");
        int anio = scanner.nextInt();

        System.out.print("Duracion en minutos: ");
        int duracion = scanner.nextInt();

        System.out.print("Numero de vistas: ");
        int vistas = scanner.nextInt();

        System.out.println("Categorias disponibles:");
        System.out.println("1 = Comedia");
        System.out.println("2 = Accion");
        System.out.println("3 = Animada");
        System.out.print("Escribe el ID de la categoria: ");
        int idCategoria = scanner.nextInt();

        System.out.println("Clasificaciones disponibles:");
        System.out.println("1 = G  (Todo publico)");
        System.out.println("2 = PG (Se sugiere guia de padres)");
        System.out.println("3 = PG-13 (Mayores de 13)");
        System.out.println("4 = R  (Mayores de 17)");
        System.out.print("Escribe el ID de la clasificacion: ");
        int idClasificacion = scanner.nextInt();

        // creo el objeto y le pongo los datos
        Pelicula nueva = new Pelicula();
        nueva.setTitulo(titulo);
        nueva.setDirector(director);
        nueva.setAnio(anio);
        nueva.setDuracionMin(duracion);
        nueva.setVistas(vistas);
        nueva.setIdCategoria(idCategoria);
        nueva.setIdClasificacion(idClasificacion);

        dao.agregar(nueva);
    }

    public void filtrar() {
        System.out.print("Desde que anio quieres filtrar: ");
        int anioDesde = scanner.nextInt();

        System.out.print("Hasta que anio quieres filtrar: ");
        int anioHasta = scanner.nextInt();

        System.out.println("Categorias disponibles:");
        System.out.println("1 = Comedia");
        System.out.println("2 = Accion");
        System.out.println("3 = Animada");
        System.out.print("Escribe el ID de la categoria: ");
        int idCategoria = scanner.nextInt();

        List<Pelicula> lista = dao.filtrarPorAnioYCategoria(anioDesde, anioHasta, idCategoria);

        if (lista.size() == 0) {
            System.out.println("No se encontraron peliculas con esos criterios");
        } else {
            System.out.println("Peliculas encontradas:");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
        }
    }
}