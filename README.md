# peliculas
catalogo de peliculas en java y en neon con una base de datos. Es un sistema que funciona como catalogo de peliculas en el cual se guardan en una base de datos.

# ¿COMO HACERLO  FUNCIONAR?
 Puedes forkear el proyecto para descargarlo desde tu pc, teniendo asi acceso a el. Buscas el archivo "Main.java" debes entrar en el para que el archivo pueda correr, dandole click en RUN. 

#  ¿QUE HACE EL  PROGRAMA?
-Puedes buscar peliculas por el ID teniendo el cuenta que este se encuentra en las tablas de neon, es importante mirar antes las tablas para saber el número con lo cual si se escribe uno que no exite, el sistema te dira que no hay uno que exista.

-Te muestra  la lista de peliculas que he agregado, que estan guardadas en la base de datos.

-Tambien si deseas agregar peliculas estas se pueden agregar, insertando un titulo, año, director y más cosas segun el  gusto.

-Se filtran peliculas por año y categoria, si se esta buscando algo en especifico, en la terminal saldria solo la respuesta de lo que se esta buscando en especifico.

-IMPORTANTE para salir del programa se debe escribir un 0.

# Estructura de las carpetas y organización

-dao: En esta carpeta se encuentran los archivos con codigo de SQL como es el INSERT Y SELECT.

-db: Aca esta la conexión a la base de datos de neon.

-menu: Aca esta el menu con los Systems.out.println con lo cual el usuario elige que hacer.

-model: Aca esta  el archivo Pelicula.java en donde estan las variables y metodos get y set.

-main: Es el que arranca todo el menu.

