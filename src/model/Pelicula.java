//clase para guardar las peliculas
public class Pelicula   {
    private int id;
    private     String titulo;
    private String director;
    private int año;
    private int duracionMins;
    private int visitas;
    private int idCategoria;
    private int idClasificacion;

    public Pelicula(){
    }
    public Pelicula  (int nuevoid, String nuevoTitulo, String nuevoDirector, int nuevoAño, int nuevoMins, int nuevasVistas, int nuevaCategoria, int nuevaClasificacion){
        id = nuevoid
                titulo=nuevoTitulo
                        director=nuevoDirector
                                año=nuevoAño
                                        duracionMins=nuevoMins
                                                vistas=nuevasVistas

    }
}