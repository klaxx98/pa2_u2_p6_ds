package ec.edu.uce.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="ciudadano")
public class Ciudadano {

    @Id
    @SequenceGenerator(name="seq_ciudadano_generador", sequenceName="seq_ciudadano", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_ciudadano_generador")
    @Column(name="ciud_id")
    private Integer id;

    @Column(name="ciud_nombre")
    private String nombre;

    @Column(name="ciud_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    public Ciudadano(Integer id, String nombre, LocalDateTime fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;

    }

    public Ciudadano() {

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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;

    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ciudadano{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();
        
    }

}
