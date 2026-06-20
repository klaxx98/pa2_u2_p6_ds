package ec.edu.uce;

import java.util.List;

import ec.edu.uce.application.service.AlumnoService;
import ec.edu.uce.application.service.MateriaService;
import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.model.Materia;
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
        private AlumnoService alumnoService;

        @Inject
        private MateriaService materiaService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("\n***Abriendo app***\n");
            
            // Alumno con dos materias

            /*
            ALUMNO
            */
            /* Alumno a1 = new Alumno();
            a1.setNombre("David"); */
            
            /*
            MATERIAS
            */
            /* Materia m1 = new Materia();
            m1.setNombre("P. Avanzada");
            m1.setNumeroCreditos(25);

            Materia m2 = new Materia();
            m2.setNombre("P. Web");
            m2.setNumeroCreditos(20);

            List<Materia> materiasA1 = new ArrayList<>();
            List<Materia> materiasA2 = new ArrayList<>(); */

            
            /* materiasA1 = List.of(m1, m2);
            a1.setMaterias(materiasA1); */

                // Insert mediante AlumnoService
                //this.alumnoService.crearAlumno(a1);
            
            // Materia con dos alumnos
            /* Materia m3 = new Materia();
            m3.setNombre("P. Distribuida");
            m3.setNumeroCreditos(8);

            Alumno a2 = new Alumno();
            a2.setNombre("Alexander");
            a2.setMaterias(List.of(m3));

            Alumno a3 = new Alumno();
            a3.setNombre("Salazar");
            a3.setMaterias(List.of(m3));

            m3.setAlumnos(List.of(a2, a3)); */

                // Insert mediante MateriaService
                //this.materiaService.crearMateria(m3);
            
            Materia m4 = new Materia();
            m4.setNombre("P. Avanzada");
            m4.setNumeroCreditos(30);

            Materia m5 = new Materia();
            m5.setNombre("P. Web");
            m5.setNumeroCreditos(25);

            Alumno a4 = new Alumno();
            a4.setNombre("David");
            a4.setMaterias(List.of(m4, m5));

            Alumno a5 = new Alumno();
            a5.setNombre("Alexander");
            a5.setMaterias(List.of(m4));

            m4.setAlumnos(List.of(a4, a5));

            // Buscar Alumnos por Id de Materia

            /* this.materiaService.crearMateria(m4);
            System.out.println(this.materiaService.buscarPorId(1));
            this.materiaService.buscarPorId(1).getAlumnos().forEach(System.out::println); */

            // Buscar Materias por Id de Alumno
            this.alumnoService.crearAlumno(a4);
            System.out.println(this.alumnoService.buscarPorId(1));
            this.alumnoService.buscarPorId(1).getMaterias().forEach(System.out::println);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
