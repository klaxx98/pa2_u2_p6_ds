package ec.edu.uce.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="transferencia")
public class Transferencia {

    @Id
    @SequenceGenerator(name="seq_transferencia_generador", sequenceName="seq_transferencia", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_transferencia_generador")
    @Column(name="tran_id")
    private Integer id;

    // Una transferencia tiene una cuenta que realiza la transaccion
    
    @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="tran_cuenta_origen", nullable=false)
    private CuentaBancaria cuentaOrigen;

    @Column(name="tran_cuenta_destino")
    private String cuentaDestino;

    @Column(name="tran_monto")
    private BigDecimal monto;

    @Column(name="tran_fecha_transferencia")
    private LocalDateTime fechaTransferencia;

    public Transferencia(Integer id, BigDecimal monto, LocalDateTime fechaTransferencia) {
        this.id = id;
        this.monto = monto;
        this.fechaTransferencia = fechaTransferencia;

    }

    public Transferencia() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CuentaBancaria getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaTransferencia() {
        return fechaTransferencia;
    }

    public void setFechaTransferencia(LocalDateTime fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transferencia{");
        sb.append("id=").append(id);
        sb.append(", cuentaOrigen=").append(cuentaOrigen);
        sb.append(", cuentaDestino=").append(cuentaDestino);
        sb.append(", monto=").append(monto);
        sb.append(", fechaTransferencia=").append(fechaTransferencia);
        sb.append('}');
        return sb.toString();

    }

}
