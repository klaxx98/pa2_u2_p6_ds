package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @SequenceGenerator(name="seq_pedido_generador", sequenceName="seq_pedido", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_pedido_generador")
    @Column(name="pedi_id")
    private Integer id;

    @Column(name="pedi_total")
    private Double total;

    @Column(name="pedi_fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name="pedi_cliente_id")
    private Cliente cliente;

    public Pedido(Integer id, Double total, LocalDate fecha) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;

    }

    public Pedido() {

    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public Double getTotal() {
        return total;

    }

    public void setTotal(Double total) {
        this.total = total;

    }

    public LocalDate getFecha() {
        return fecha;

    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido{");
        sb.append("id=").append(id);
        sb.append(", total=").append(total);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();

    }

}
