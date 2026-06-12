package ec.edu.uce.infrastructure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Alcalde;
import ec.edu.uce.domain.repository.AlcaldeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class AlcaldeRepositoryImpl implements AlcaldeRepository {

    @Inject
    EntityManager em;

    @Override
    public void create(Alcalde alcalde) {
        this.em.persist(alcalde);

    }

    @Override
    public List<Alcalde> findByNombre(String nombre) {
        TypedQuery<Alcalde> myQuery = this.em.createQuery("SELECT a FROM Alcalde a WHERE a.nombre = :nombre", Alcalde.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();

    }

}
