package ec.edu.uce.infrastructure.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
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

    // 1. Queries
    // 1.1. TypedQuery: JPQL (Java Persistence Query Language)
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

    // 1.2. NamedQuery: SQL (Structured Query Language)
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

    // 2. NativeQuery: SQL (Structured Query Language)

    @SuppressWarnings("unchecked")
    @Override
    public List<Estudiante> selectAllNative() {
        Query myQuery = this.em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
        return myQuery.getResultList();
        
    }

    // 3. Criteria API Query: API de Java para construir consultas de manera programática,
    // utilizando objetos y métodos en lugar de escribir consultas en forma de texto.

    @Override
    public List<Estudiante> selectAllCriteria() {
        // Crear una instancia de la clase que va a ser la encargada de construir la consulta
        // CriteriaBuilder: Proporciona métodos para construir consultas de manera programática
        CriteriaBuilder cb = this.em.getCriteriaBuilder();

        // Definir el tipo de objeto que va a retornar la consulta
        CriteriaQuery<Estudiante> myQuery = cb.createQuery(Estudiante.class);

        // Se definen las estidades del FROM
        Root<Estudiante> root = myQuery.from(Estudiante.class);
        
        // Defino con qué tipo de SQL se va a trabajar: SELECT, UPDATE, DELETE
        // myQuery está haciendo un SELECT al FROM definido por root, que es la entidad Estudiante
        myQuery.select(root);

        // Hasta aquí se termina de construir myQuery

        // Transformar myQuery a un query ejecutable
        // El EntityManager crea un TypedQuery a partir de myQuery, que es un CriteriaQuery
        TypedQuery<Estudiante> query = this.em.createQuery(myQuery);
        return query.getResultList();

    }

    @Override
    public List<Estudiante> selectByNombreCriteria(String nombre) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> myQuery = cb.createQuery(Estudiante.class);
        Root<Estudiante> root = myQuery.from(Estudiante.class);
        // equal 1. Qué voy a comparar, 2. Con qué voy a comparar
        // WHERE e.nombre = 'nombre'
        Predicate p1 = cb.equal(root.get("nombre"), nombre);
        myQuery.select(root).where(p1);

        TypedQuery<Estudiante> query = this.em.createQuery(myQuery);
        return query.getResultList();

    }

    // Consular un query de estudiante de nombre y apellido
    // siempre y cuando el nombre o el apellido no sean nulos
    // si ambos son nulos, se arroja un SELECT * FROM estudiante

    @Override
    public List<Estudiante> selectDynamicCriteria(String nombre, String apellido) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> myQuery = cb.createQuery(Estudiante.class);
        Root<Estudiante> root = myQuery.from(Estudiante.class);

        List<Predicate> condiciones = new ArrayList<>();

        if (nombre != null) {
            Predicate p1 = cb.equal(root.get("nombre"), nombre);
            condiciones.add(p1);
        }
        
        if (apellido != null) {
            Predicate p2 = cb.equal(root.get("apellido"), apellido);
            condiciones.add(p2);
        }

        myQuery.select(root).where(condiciones);

        TypedQuery<Estudiante> query = this.em.createQuery(myQuery);
        return query.getResultList();

    }

}
