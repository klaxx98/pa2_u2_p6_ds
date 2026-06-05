package ec.edu.uce.infrastructure.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

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

    // Criteria API Query

	@Override
	public List<Profesor> selectAllCriteria() {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = myQuery.from(Profesor.class);
        myQuery.select(root);
        
        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();

    }

	@Override
	public List<Profesor> selectByNombreCriteria(String nombre) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = myQuery.from(Profesor.class);
        Predicate p1 = cb.equal(root.get("nombre"), nombre);
        myQuery.select(root).where(p1);

        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();

    }

	@Override
	public List<Profesor> selectByFacultadCriteria(String facultad) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = myQuery.from(Profesor.class);
        Predicate p2 = cb.equal(root.get("facultad"), facultad);
        myQuery.select(root).where(p2);

        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();

	}

	@Override
	public List<Profesor> selectByEspecialidadCriteria(String especialidad) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = myQuery.from(Profesor.class);
        Predicate p3 = cb.equal(root.get("especialidad"), especialidad);
        myQuery.select(root).where(p3);

        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();

	}

	@Override
	public List<Profesor> selectDynamicCriteria(String nombre, String apellido) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = myQuery.from(Profesor.class);

        List<Predicate> condiciones = new ArrayList<>();

        if (nombre != null) {
            Predicate p1 = cb.equal(root.get("nombre"), nombre);
            condiciones.add(p1);
        } if (apellido != null) {
            Predicate p2 = cb.equal(root.get("apellido"), apellido);
            condiciones.add(p2);
        }

        myQuery.select(root).where(condiciones);

        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();
        
	}

}
