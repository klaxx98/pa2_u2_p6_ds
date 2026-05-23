package ec.edu.uce.infrastructure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class EstudianteRepositoryImpl implements EstudianteRepository {

    // Principal gestor de persistencia,
    // se encarga de realizar las operaciones de persistencia
    @Inject
    private EntityManager em;

    @Override
    public void create(Estudiante estudiante) {
        this.em.persist(estudiante);
        
    }

    @Override
    public Estudiante selectById(Integer id) {
        return this.em.find(Estudiante.class, id);
    
    }

    @Override
    public void update(Estudiante estudiante) {
        this.em.merge(estudiante);
    
    }

    @Override
    public void deleteById(Integer id) {
        this.em.remove(this.selectById(id));
    
    }

    //Con TypedQuery
    @Override
    public List<Estudiante> selectAll() {
        TypedQuery<Estudiante> myQuery = this.em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return myQuery.getResultList();
        
    }

    @Override
    public List<Estudiante> selectByNombre(String nombre) {
                                                                    //SELECT * FROM estudiante WHERE estu_nombre = '?'
        TypedQuery<Estudiante> myQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :nombre", Estudiante.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();

    }

    @Override
    public Estudiante selectByCedula(String cedula) {
        TypedQuery<Estudiante> myQuery = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula", Estudiante.class);
        myQuery.setParameter("cedula", cedula);
        //return myQuery.getSingleResult();
        //return myQuery.getResultList().get(0);
        return myQuery.getResultList().getFirst();

    }

}
