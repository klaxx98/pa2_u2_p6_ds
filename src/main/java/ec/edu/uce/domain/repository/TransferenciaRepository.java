package ec.edu.uce.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.domain.model.Transferencia;

public interface TransferenciaRepository {

    public Transferencia findById(Integer id);
    public List<Transferencia> findByCuentaOrigen(String cuentaOrigen);
    public void createTransaction(String origen, String destino, BigDecimal monto);

}
