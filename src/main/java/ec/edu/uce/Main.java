package ec.edu.uce;

import java.time.LocalDateTime;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Ciudadano;
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
        private EstudianteService estudianteService;

        @Inject
        private ProfesorService profesorService;

        @Inject
        private CiudadanoService ciudadanoService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("***Abriendo app***");

            /*
            CIUDADANO
            */
            Ciudadano ciudadano = new Ciudadano();
            ciudadano.setNombre("David Salazar");
            ciudadano.setFechaNacimiento(LocalDateTime.now());

            this.ciudadanoService.guardar(ciudadano);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
