package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Doctor;
import ec.edu.uce.domain.repository.DoctorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DoctorService {

    @Inject
    private DoctorRepository doctorRepository;

    public void crearDoctor(Doctor doctor) {
        this.doctorRepository.create(doctor);

    }

}
