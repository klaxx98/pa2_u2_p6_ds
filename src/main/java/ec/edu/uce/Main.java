package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.AlcaldeService;
import ec.edu.uce.application.service.CiudadService;
import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Alcalde;
import ec.edu.uce.domain.model.Ciudad;
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

        @Inject
        private AlcaldeService alcaldeService;

        @Inject
        private CiudadService ciudadService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("***Abriendo app***");

            /*
            CIUDAD
            */

            Ciudad ciudad = new Ciudad();
            ciudad.setId(1);
            ciudad.setCodigo("UIO");
            ciudad.setNombre("Quito");
            
            this.ciudadService.crearCiudad(ciudad);

            /*
            ALCALDE
            */

            Alcalde alcalde = new Alcalde();
            alcalde.setId(1);
            alcalde.setNombre("Pabel Muñoz");
            alcalde.setPartido("RC");
            alcalde.setFechaPosesion(LocalDate.now());
            alcalde.setCiudad(ciudad);

            this.alcaldeService.crearAlcalde(alcalde);

            this.ciudadService.buscarPorNombre("Quito").forEach(System.out::println);
            this.alcaldeService.buscarPorNombre("Pabel Muñoz").forEach(System.out::println);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
