package ec.edu.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.DoctorService;
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

        @Override
        public int run(String... args) throws Exception {

            System.out.println("***Abriendo app***");

            /*
            DOCTORES
            */
            Doctor d1 = new Doctor();
            d1.setNombre("Doctor 1");
            d1.setEspecialidad("General");
            d1.setConsultorio("A1");

            Doctor d2 = new Doctor();
            d2.setNombre("Doctor 2");
            d2.setEspecialidad("Cardiología");

            List<Doctor> doctores = new ArrayList<>();
            doctores.add(d1);

            /*
            PACIENTES
            */
            Paciente p1 = new Paciente();
            p1.setCedula("0123456789");
            p1.setNombre("Paciente 1");
            p1.setFechaNacimiento(LocalDate.of(2000, 01, 01));

            Paciente p2 = new Paciente();
            p2.setCedula("9876543210");
            p2.setNombre("Paciente 2");
            p2.setFechaNacimiento(LocalDate.of(2005, 05, 05));

            List<Paciente> pacientes = new ArrayList<>();
            pacientes.add(p1);
            pacientes.add(p2);

            /*
            DOCTOR-PACIENTE
            */
            d1.setPacientes(pacientes);
            p1.setDoctores(doctores);
            p2.setDoctores(doctores);

            // AGREGAR USANDO SERVICE
            // this.doctorService.crearDoctor(d1);

            System.out.println("\n***Cerrando app***\n");

            return 0;
            
        }
        
    }

}
