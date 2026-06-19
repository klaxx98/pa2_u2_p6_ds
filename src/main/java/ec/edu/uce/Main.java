package ec.edu.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.DirectorService;
import ec.edu.uce.domain.model.Director;
import ec.edu.uce.domain.model.Pelicula;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private DirectorService directorService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("***Abriendo app***");

            /*
            DIRECTOR
            */
            Director director = new Director();
            director.setNombre("Steven Spielberg");
            director.setNacionalidad("Estadounidense");

            /*
            PELICULAS
            */
            Pelicula p1 = new Pelicula();
            p1.setTitulo("Jurassic Park");
            p1.setFechaEstreno(LocalDate.of(1993, 6, 9));

            Pelicula p2 = new Pelicula();
            p2.setTitulo("La Guerra de los Mundos");
            p2.setFechaEstreno(LocalDate.of(2005, 6, 23));

            List<Pelicula> peliculas = new ArrayList<>();
            peliculas.add(p1);
            peliculas.add(p2);

            director.setPeliculas(peliculas);

            this.directorService.crearDirector(director);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
