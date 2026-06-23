package ec.edu.uce.application.service;

import java.math.BigDecimal;
import java.util.List;

import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TransferenciaService {

    @Inject
    private TransferenciaRepository transferenciaRepository;

    public void crearTransferencia() {

    }

    public Transferencia buscarPorId(Integer id) {
        return this.transferenciaRepository.findById(id);

    }

    public List<Transferencia> buscarPorCuentaOrigen(String cuentaOrigen) {
        return this.transferenciaRepository.findByCuentaOrigen(cuentaOrigen);

    }

    public void realizarTransferencia(String origen, String destino, BigDecimal monto) {
        System.out.println("Realizando transferencia desde cuenta: "+ origen +
                            " a la cuenta: " + destino +
                            " por el monto de: $" + monto);

        System.out.println("... Validando transacción...");

        this.transferenciaRepository.createTransaction(origen, destino, monto);

    }

}
