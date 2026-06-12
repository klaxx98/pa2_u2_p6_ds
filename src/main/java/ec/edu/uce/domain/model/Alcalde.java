package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="alcalde")
public class Alcalde {

    @Id
    @SequenceGenerator(name="seq_alcalde_generador", sequenceName="seq_alcalde", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_alcalde_generador")
    @Column(name="alca_id")
    private Integer id;

    @Column(name="alca_nombre")
    private String nombre;

    @Column(name="alca_partido")
    private String partido;

    @Column(name="alca_fecha_posesion")
    private LocalDate fechaPosesion;

    @OneToOne
    @JoinColumn(name="alca_ciudad")
    private Ciudad ciudad;

    public Alcalde(Integer id, String nombre, String partido, LocalDate fechaPosesion, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.partido = partido;
        this.fechaPosesion = fechaPosesion;
        this.ciudad = ciudad;

    }

    public Alcalde() {

    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getPartido() {
        return partido;

    }

    public void setPartido(String partido) {
        this.partido = partido;

    }

    public LocalDate getFechaPosesion() {
        return fechaPosesion;

    }

    public void setFechaPosesion(LocalDate fechaPosesion) {
        this.fechaPosesion = fechaPosesion;

    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Alcalde [id=" + id + ", nombre=" + nombre + ", partido=" + partido + ", fechaPosesion=" + fechaPosesion
                + "]";

    }

}
