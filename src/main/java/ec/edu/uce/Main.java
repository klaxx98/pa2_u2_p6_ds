package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Profesor;
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

        @Override
        public int run(String... args) throws Exception {

            System.out.println("***Abriendo app***");

            /*
            ESTUDIANTE
            */

            /* System.out.println("\n***Guardar Estudiante***\n");

            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Juan");
            estudiante.setApellido("Perez");
            estudiante.setGenero("M");
            estudiante.setFechaNacimiento(LocalDate.of(2000, 01, 01));
            estudiante.setCedula("1234567890");

            this.estudianteService.guardar(estudiante);

            System.out.println("\n***TypedQueries y NamedQueries***\n");

            this.estudianteService.buscarPorGenero("M").forEach(System.out::println);
            this.estudianteService.buscarPorGenero2("M").forEach(System.out::println);
            this.estudianteService.buscarPorApellido("Salazar").forEach(System.out::println);
            this.estudianteService.buscarPorRangoFechas(LocalDate.of(1996, 01, 01), LocalDate.of(2000, 12, 31)).forEach(System.out::println);
            System.out.println("Número de estudiantes: " + this.estudianteService.seleccionarContar());

            System.out.println("\n***NativeQuery***\n");

            this.estudianteService.listarTodosNative().forEach(System.out::println); */

            /*
            PROFESOR
            */

            System.out.println("\n***Profesor***\n");

            Profesor profesor1 = new Profesor();
            profesor1.setNombre("Edison");
            profesor1.setApellido("Cayambe");
            profesor1.setFechaNacimiento(LocalDate.of(1980, 01, 01));
            profesor1.setCedula("1122334455");
            profesor1.setGenero("M");
            profesor1.setFacultad("FING");
            profesor1.setEspecialidad("Programacion avanzada II");

            this.profesorService.guardar(profesor1);

            System.out.println(this.profesorService.buscarPorId(1));

            Profesor profesor2 = new Profesor();
            profesor2.setNombre("Byron");
            profesor2.setApellido("Torres");
            profesor2.setFechaNacimiento(LocalDate.of(1985, 05, 05));
            profesor2.setCedula("5544332211");
            profesor2.setGenero("M");
            profesor2.setFacultad("FING");
            profesor2.setEspecialidad("Base de datos II");

            this.profesorService.guardar(profesor2);

            System.out.println("\n***NamedQuery***\n");

            this.profesorService.buscarPorGenero("M").forEach(System.out::println);
            this.profesorService.buscarPorApellido("Cayambe").forEach(System.out::println);
            this.profesorService.buscarPorRangoFechas(LocalDate.of(1975, 01, 01), LocalDate.of(1984, 12, 31)).forEach(System.out::println);
            this.profesorService.buscarPorFacultad("FING").forEach(System.out::println);
            this.profesorService.buscarPorEspecialidadNamed("Programacion avanzada II").forEach(System.out::println);
            System.out.println("Número de profesores: " + this.profesorService.seleccionarContar());

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
