package ec.edu.uce;

import java.time.LocalDateTime;

import ec.edu.uce.application.service.AlcaldeService;
import ec.edu.uce.application.service.CiudadService;
import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
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

        @Inject
        private EmpleadoService empleadoService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("***Abriendo app***");

            /*
            CIUDADANO
            */
            Ciudadano ciudadano = new Ciudadano();
            ciudadano.setNombre("Ciudadano 1");
            ciudadano.setFechaNacimiento(LocalDateTime.of(2000, 01, 01, 15, 30));

            //this.ciudadanoService.guardar(ciudadano);

            /*
            EMPLEADO
            */
            Empleado empleado = new Empleado();
            empleado.setSalario(null);
            empleado.setFechaIngreso(LocalDateTime.now());

            this.empleadoService.guardar(empleado);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
