package ec.edu.uce.infrastructure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @Inject
    private EntityManager em;

    @Override
    public void create(Profesor profesor) {
        this.em.persist(profesor);

    }

    @Override
    public Profesor selectById(Integer id) {
        return this.em.find(Profesor.class, id);
    
    }

    @Override
    public void update(Profesor profesor) {
        this.em.merge(profesor);
    
    }

    @Override
    public void deleteById(Integer id) {
        this.em.remove(this.selectById(id));
    
    }

    @Override
    public List<Profesor> selectAll() {
        TypedQuery<Profesor> myQuery = this.em.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return myQuery.getResultList();

    }

    @Override
    public List<Profesor> selectByNombre(String nombre) {
        TypedQuery<Profesor> myQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.nombre = :nombre", Profesor.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();
        
    }

    @Override
    public Profesor selectByCedula(String cedula) {
        TypedQuery<Profesor> myQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.cedula = :cedula", Profesor.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getSingleResult();

    }

    @Override
    public Profesor selectByEspecialidad(String especialidad) {
        TypedQuery<Profesor> myQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.especialidad = :especialidad", Profesor.class);
        myQuery.setParameter("especialidad", especialidad);
        return myQuery.getSingleResult();
        
    }

}
