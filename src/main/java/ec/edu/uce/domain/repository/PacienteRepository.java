package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Paciente;

public interface PacienteRepository {

    public void create(Paciente paciente);
    public Paciente findById(Integer id);


}
