package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.CuentaBancaria;
import ec.edu.uce.domain.repository.CuentaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaService {

    @Inject
    private CuentaRepository cuentaRepository;

    public void crearCuenta(CuentaBancaria cuentaBancaria) {
        this.cuentaRepository.create(cuentaBancaria);

    }

    public CuentaBancaria buscarPorId(Integer id) {
        return this.cuentaRepository.findById(id);

    }

    public CuentaBancaria buscarPorNumeroCuenta(String numeroCuenta) {
        return this.cuentaRepository.findByNumeroCuenta(numeroCuenta);
        
    }

    public CuentaBancaria buscarPorCedula(String cedula) {
        return this.cuentaRepository.findByCedula(cedula);
        
    }

}
