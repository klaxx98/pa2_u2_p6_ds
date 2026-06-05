package ec.edu.uce;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.ProfesorService;
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

            /* System.out.println("\n***Criteria API Query***\n");
            this.estudianteService.listarTodosCriteria().forEach(System.out::println);
            this.estudianteService.buscarPorNombreCriteria("David").forEach(System.out::println);

            this.estudianteService.buscarDynamicCriteria("David", "Salazar").forEach(System.out::println);
            this.estudianteService.buscarDynamicCriteria("David", null).forEach(System.out::println);
            this.estudianteService.buscarDynamicCriteria(null, "Salazar").forEach(System.out::println);
            this.estudianteService.buscarDynamicCriteria(null, null).forEach(System.out::println); */

            /*
            PROFESOR
            */

            System.out.println("\n***Criteria API***\n");

            this.profesorService.listarTodosCriteria().forEach(System.out::println);
            this.profesorService.buscarPorNombreCriteria("Edison").forEach(System.out::println);
            this.profesorService.buscarPorFacultad("FING").forEach(System.out::println);
            this.profesorService.buscarPorEspecialidadCriteria("Base de datos II").forEach(System.out::println);
            this.profesorService.buscarDynamicCriteria("Edison", "Cayambe").forEach(System.out::println);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
