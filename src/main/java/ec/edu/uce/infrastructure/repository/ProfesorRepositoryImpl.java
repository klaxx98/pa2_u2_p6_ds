package ec.edu.uce.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    // TypedQuery

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

    // NamedQuery

    @Override
    public List<Profesor> selectByGenero(String genero) {
        TypedQuery<Profesor> myQuery = this.em.createNamedQuery("Profesor.buscarPorGenero", Profesor.class);
        myQuery.setParameter("genero", genero);
        return myQuery.getResultList();
        
    }

    @Override
    public List<Profesor> selectByApellido(String apellido) {
        TypedQuery<Profesor> myQuery = this.em.createNamedQuery("Profesor.buscarPorApellido", Profesor.class);
        myQuery.setParameter("apellido", apellido);
        return myQuery.getResultList();
    
    }

    @Override
    public List<Profesor> selectByRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        TypedQuery<Profesor> myQuery = this.em.createNamedQuery("Profesor.buscarPorRangoFecha", Profesor.class);
        myQuery.setParameter("inicio", fechaInicio);
        myQuery.setParameter("fin", fechaFin);
        return myQuery.getResultList();

    }

    @Override
    public List<Profesor> selectByFacultad(String facultad) {
        TypedQuery<Profesor> myQuery = this.em.createNamedQuery("Profesor.buscarPorFacultad", Profesor.class);
        myQuery.setParameter("facultad", facultad);
        return myQuery.getResultList();

    }

    @Override
    public List<Profesor> selectByEspecialidadNamed(String especialidad) {
        TypedQuery<Profesor> myQuery = this.em.createNamedQuery("Profesor.buscarPorEspecialidad", Profesor.class);
        myQuery.setParameter("especialidad", especialidad);
        return myQuery.getResultList();
        
    }

    @Override
    public Long seleccionarContar() {
        TypedQuery<Long> myQuery = this.em.createNamedQuery("Profesor.contar", Long.class);
        return myQuery.getSingleResult();

    }

    // NativeQuery

    @SuppressWarnings("unchecked")
    @Override
    public List<Profesor> selectAllNative() {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
        return myQuery.getResultList();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Profesor> selectByApellidoNative(String apellido) {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_apellido = :apellido", Profesor.class);
        myQuery.setParameter("apellido", apellido);
        return myQuery.getResultList();
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Profesor> selectByFacultadNative(String facultad) {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_facultad = :facultad", Profesor.class);
        myQuery.setParameter("facultad", facultad);
        return myQuery.getResultList();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Profesor> selectByEspecialidadNative(String especialidad) {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_especialidad = :especialidad", Profesor.class);
        myQuery.setParameter("especialidad", especialidad);
        return myQuery.getResultList();
        
    }

}
