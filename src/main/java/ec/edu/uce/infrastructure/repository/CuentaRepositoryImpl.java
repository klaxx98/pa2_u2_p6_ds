package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.repository.CuentaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class CuentaRepositoryImpl implements CuentaRepository {

    @Inject
    private EntityManager em;

    @Override
    public void create(CuentaBancaria cuentaBancaria) {
        this.em.persist(cuentaBancaria);

    }

    @Override
    public CuentaBancaria findById(Integer id) {
        return this.em.find(CuentaBancaria.class, id);

    }

    @Override
    public CuentaBancaria findByCedula(String cedula) {
        TypedQuery<CuentaBancaria> myQuery =  this.em.createQuery("SELECT c FROM CuentaBancaria c WHERE c.cedula = :cedula", CuentaBancaria.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getSingleResult();

    }

    @Override
    public CuentaBancaria findByNumeroCuenta(String numeroCuenta) {
        TypedQuery<CuentaBancaria> myQuery =  this.em.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numeroCuenta = :numeroCuenta", CuentaBancaria.class);
        myQuery.setParameter("numeroCuenta", numeroCuenta);
        return myQuery.getSingleResult();
        
    }

}
