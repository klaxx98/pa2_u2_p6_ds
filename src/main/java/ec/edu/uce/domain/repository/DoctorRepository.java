package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Doctor;

public interface DoctorRepository {
    
    public void create(Doctor doctor);
    public Doctor findById(Integer id);

}
