package ec.edu.uce.infrastructure.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.CuentaRepository;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class TransferenciaRepositoryImpl implements TransferenciaRepository {

    @Inject
    private EntityManager em;

    @Inject
    private CuentaRepository cR;

    @Override
    public Transferencia findById(Integer id) {
        return this.em.find(Transferencia.class, id);
        
    }

    @Override
    public List<Transferencia> findByCuentaOrigen(String cuentaOrigen) {
        TypedQuery<Transferencia> myQuery = this.em.createQuery("SELECT t FROM Transferencia t WHERE t.cuentaOrigen = :cuentaOrigen", Transferencia.class);
        myQuery.setParameter("cuentaOrigen", cuentaOrigen);
        return myQuery.getResultList();
        
    }

    @Override
    public void createTransaction(String origen, String destino, BigDecimal monto) {
        CuentaBancaria cuentaOrigen = this.cR.findByNumeroCuenta(origen);
        CuentaBancaria cuentaDestino = this.cR.findByNumeroCuenta(destino);

        if (cuentaOrigen == null || cuentaDestino == null) {
            throw new IllegalArgumentException("Una o ambas cuentas no existen");
        }

        if (cuentaOrigen.getSaldo().compareTo(monto) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        // Debito a la cuenta origen
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(monto));
        // Acreditación a la cuenta destino
        cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(monto));

        Transferencia tr = new Transferencia();
        tr.setCuentaOrigen(cuentaOrigen);
        tr.setCuentaDestino(destino);
        tr.setMonto(monto);
        tr.setFechaTransferencia(LocalDateTime.now());

        this.em.persist(tr);
        System.out.println("¡Transferencia exitosa!");

    }

}
