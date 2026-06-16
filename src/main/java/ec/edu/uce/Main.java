package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.AlcaldeService;
import ec.edu.uce.application.service.CiudadService;
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
        private AlcaldeService alcaldeService;

        @Inject
        private CiudadService ciudadService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("***Abriendo app***");

            /*
            CIUDAD
            */
            Ciudad ciudad1 = new Ciudad();
            ciudad1.setCodigo("UIO");
            ciudad1.setNombre("Quito");

            this.ciudadService.crearCiudad(ciudad1);

            /*
            ALCALDE
            */
            Alcalde alcalde1 = new Alcalde();
            alcalde1.setNombre("Pabel Muñoz");
            alcalde1.setPartido("RC");
            alcalde1.setFechaPosesion(LocalDate.now());
            alcalde1.setCiudad(ciudad1);

            this.alcaldeService.crearAlcalde(alcalde1);

            /*
            CIUDAD ALCALDE
            */
            Ciudad ciudad2 = new Ciudad();
            ciudad2.setCodigo("GYE");
            ciudad2.setNombre("Guayaquil");

            Alcalde alcalde2 = new Alcalde();
            alcalde2.setNombre("Alquiles Alvarez");
            alcalde2.setPartido("RC");
            alcalde2.setFechaPosesion(LocalDate.now());

            this.alcaldeService.crearAlcaldeCiudad(alcalde2, ciudad2);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
