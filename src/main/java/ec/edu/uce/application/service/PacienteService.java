package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Paciente;
import ec.edu.uce.domain.repository.PacienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PacienteService {

    @Inject
    private PacienteRepository pacienteRepository;

    public void crearPaciente(Paciente paciente) {
        this.pacienteRepository.create(paciente);

    }

    public Paciente buscarPorId(Integer id) {
        return this.pacienteRepository.findById(id);
        
    }

}
