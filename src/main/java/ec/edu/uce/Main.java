package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.ProfesorService;
import ec.edu.uce.domain.model.Estudiante;
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

            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Juan");
            estudiante.setApellido("Perez");
            estudiante.setGenero("M");
            estudiante.setFechaNacimiento(LocalDate.of(2000, 01, 01));

            this.estudianteService.guardar(estudiante);

            System.out.println(this.estudianteService.buscarPorId(1));
            System.out.println(this.estudianteService.buscarPorId(2));

            Estudiante estudianteActualizar = new Estudiante();
            estudianteActualizar.setId(2);
            estudianteActualizar.setNombre("Maria");
            estudianteActualizar.setApellido("Gomez");
            estudianteActualizar.setGenero("F");
            estudianteActualizar.setFechaNacimiento(LocalDate.of(2001, 02, 02));

            this.estudianteService.actualizar(estudianteActualizar);
            System.out.println(this.estudianteService.buscarPorId(2));

            this.estudianteService.eliminarPorId(2);
            System.out.println(this.estudianteService.buscarPorId(2));

            /*
            PROFESOR
            */

            Profesor profesor1 = new Profesor();
            profesor1.setNombre("Edison");
            profesor1.setApellido("Cayambe");
            profesor1.setGenero("M");
            profesor1.setEspecialidad("Programacion avanzada II");

            this.profesorService.guardar(profesor1);

            System.out.println(this.profesorService.buscarPorId(1));

            Profesor profesor2 = new Profesor();
            profesor2.setNombre("Byron");
            profesor2.setApellido("Torres");
            profesor2.setGenero("M");
            profesor2.setEspecialidad("Base de datos II");

            this.profesorService.guardar(profesor2);

            System.out.println(this.profesorService.buscarPorId(2));

            profesor2.setEspecialidad("Ingenieria de software");

            this.profesorService.actualizar(profesor2);
            System.out.println(this.profesorService.buscarPorId(2));

            this.profesorService.eliminarPorId(2);
            System.out.println(this.profesorService.buscarPorId(2));

            System.out.println("***Cerrando app***");

            return 0;
            
        }
        
    }

}
