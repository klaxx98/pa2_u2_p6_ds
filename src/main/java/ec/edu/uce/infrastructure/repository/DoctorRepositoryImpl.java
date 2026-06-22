package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Doctor;
import ec.edu.uce.domain.repository.DoctorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class DoctorRepositoryImpl implements DoctorRepository {

    @Inject
    EntityManager em;

    @Override
    public void create(Doctor doctor) {
        this.em.persist(doctor);
        
    }

    @Override
    public Doctor findById(Integer id) {
        return this.em.find(Doctor.class, id);
        
    }

}
