package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.CuentaBancaria;

public interface CuentaRepository {

    public void create(CuentaBancaria cuentaBancaria);
    public CuentaBancaria findById(Integer id);
    public CuentaBancaria findByCedula(String cedula);
    public CuentaBancaria findByNumeroCuenta(String numeroCuenta);

}
