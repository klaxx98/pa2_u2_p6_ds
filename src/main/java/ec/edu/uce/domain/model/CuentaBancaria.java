package ec.edu.uce.domain.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="cuenta_bancaria")
public class CuentaBancaria {

    @Id
    @SequenceGenerator(name="seq_cuenta_generador", sequenceName="seq_cuenta", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_cuenta_generador")
    @Column(name="cuen_id")
    private Integer id;

    @Column(name="cuen_cedula")
    private String cedula;

    @Column(name="cuen_apellido")
    private String apellido;

    @Column(name="cuen_nombre")
    private String nombre;

    @Column(name="cuen_saldo")
    private BigDecimal saldo;

    @Column(name="cuen_tipo_cuenta")
    private String tipoCuenta;

    @Column(name="cuen_numero_cuenta")
    private String numeroCuenta;

    // Una cuenta bancaria tiene múltiples transferencias en su registro
    // Y una transferencia tiene una sola cuenta que realiza la transacción
    // La relación debe ser Uno a Muchos

    @OneToMany(mappedBy="cuentaOrigen", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    List<Transferencia> transferencias;

    public CuentaBancaria(Integer id, String cedula, String apellido, String nombre, BigDecimal saldo,String tipoCuenta, String numeroCuenta) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.id = id;
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;

    }

    public CuentaBancaria() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public List<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CuentaBancaria{");
        sb.append("id=").append(id);
        sb.append(", cedula=").append(cedula);
        sb.append(", apellido=").append(apellido);
        sb.append(", nombre=").append(nombre);
        sb.append(", saldo=").append(saldo);
        sb.append(", tipoCuenta=").append(tipoCuenta);
        sb.append(", numeroCuenta=").append(numeroCuenta);
        sb.append('}');
        return sb.toString();

    }

}
