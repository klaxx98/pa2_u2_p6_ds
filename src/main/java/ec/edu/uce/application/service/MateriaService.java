package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.repository.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MateriaService {

    @Inject
    private MateriaRepository materiaRepository;

    public void crearMateria(Materia materia) {
        this.materiaRepository.create(materia);
        
    }

    public Materia buscarPorId(Integer id) {
        return this.materiaRepository.findByIdMateria(id);

    }

}
