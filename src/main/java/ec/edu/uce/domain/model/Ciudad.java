package ec.edu.uce.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="ciudad")
public class Ciudad {

    @Id
    @SequenceGenerator(name="seq_ciudad_generador", sequenceName="seq_ciudad", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_ciudad_generador")
    @Column(name="ciudad_id")
    private Integer id;

    @Column(name="ciudad_codigo")
    private String codigo;
    @Column(name="ciudad_nombre")
    private String nombre;

    public Ciudad(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;

    }

    public Ciudad() {

    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getCodigo() {
        return codigo;

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;

    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    @Override
    public String toString() {
        return "Ciudad [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
        
    }

}
