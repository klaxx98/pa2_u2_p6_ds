package ec.edu.uce.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    // Queries
    // 1. TypedQuery: JPQL (Java Persistence Query Language)
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

    // 2. NamedQuery: SQL (Structured Query Language)
    // Declarado a nivel de entidad, con @NamedQuery: Estudiante

    @SuppressWarnings("unchecked")
    @Override
    public List<Estudiante> selectByGenero(String genero) {
        Query myQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero");
        myQuery.setParameter("genero", genero);
        return (List<Estudiante>) myQuery.getResultList();
        
    }

    @Override
    public List<Estudiante> selectByGenero2(String genero) {
        TypedQuery<Estudiante> myQuery = this.em.createNamedQuery("Estudiante.buscarPorGenero", Estudiante.class);
        myQuery.setParameter("genero", genero);
        return myQuery.getResultList();
        
    }

    @Override
    public List<Estudiante> selectByApellido(String apellido) {
        TypedQuery<Estudiante> myQuery = this.em.createNamedQuery("Estudiante.buscarPorApellido", Estudiante.class);
        myQuery.setParameter("apellido", apellido);
        return myQuery.getResultList();
        
    }

    @Override
    public List<Estudiante> selectByRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Estudiante> myQuery = this.em.createNamedQuery("Estudiante.buscarPorRangoFecha", Estudiante.class);
        myQuery.setParameter("inicio", fechaInicio);
        myQuery.setParameter("fin", fechaFin);
        return myQuery.getResultList();
        
    }

    @Override
    public Long seleccionarContar() {
        TypedQuery<Long> myQuery = this.em.createNamedQuery("Estudiante.contar", Long.class);
        return myQuery.getSingleResult();

    }

    // 3. NativeQuery: SQL (Structured Query Language)

    @SuppressWarnings("unchecked")
    @Override
    public List<Estudiante> selectAllNative() {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
        return myQuery.getResultList();
        
    }

}
