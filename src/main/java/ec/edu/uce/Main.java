package ec.edu.uce;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.application.service.DoctorService;
import ec.edu.uce.application.service.PacienteService;
import ec.edu.uce.domain.model.Doctor;
import ec.edu.uce.domain.model.Paciente;
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
        private DoctorService doctorService;

        @Inject
        private PacienteService pacienteService;

        @Override
        public int run(String... args) throws Exception {

            System.out.println("\n***Abriendo app***\n");

            // Doctor con dos pacientes

            Doctor d1 = new Doctor();
            d1.setNombre("Ramiro Ramirez");
            d1.setEspecialidad("Cardiología");
            d1.setConsultorio("AA11");

            Paciente p1 = new Paciente();
            p1.setCedula("0123456789");
            p1.setNombre("Pedrito");
            p1.setFechaNacimiento(LocalDate.of(2000, 1, 1));

            Paciente p2 = new Paciente();
            p2.setCedula("9876543210");
            p2.setNombre("Juanita");
            p2.setFechaNacimiento(LocalDate.of(2006, 6, 15));

            d1.setPacientes(List.of(p1, p2));

                this.doctorService.crearDoctor(d1);

            // Paciente con dos doctores

            Doctor d2 = new Doctor();
            d2.setNombre("John Jackson");
            d2.setEspecialidad("Traumatología");
            d2.setConsultorio("BB22");

            Doctor d3 = new Doctor();
            d3.setNombre("Jack Johnson");
            d3.setEspecialidad("Pediatría");
            d3.setConsultorio("CC33");

            Paciente p3 = new Paciente();
            p3.setCedula("0147852369");
            p3.setNombre("Luisito");
            p3.setFechaNacimiento(LocalDate.of(2020, 12, 12));

            p3.setDoctores(List.of(d2, d3));

                this.pacienteService.crearPaciente(p3);

            // Buscar Doctores por Id de Paciente

            System.out.println(this.pacienteService.buscarPorId(3));
            this.pacienteService.buscarPorId(3).getDoctores().forEach(System.out::println);

            // Buscar Pacientes por Id de Doctor

            System.out.println(this.doctorService.buscarPorId(1));
            this.doctorService.buscarPorId(1).getPacientes().forEach(System.out::println);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
