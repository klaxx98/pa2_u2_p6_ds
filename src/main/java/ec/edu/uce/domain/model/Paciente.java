package ec.edu.uce.domain.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @SequenceGenerator(name="seq_paciente_generador", sequenceName="seq_paciente", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_paciente_generador")
    @Column(name="paci_id")
    private Integer id;

    @Column(name="paci_cedula")
    private String cedula;

    @Column(name="paci_nombre")
    private String nombre;

    @Column(name="paci_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @ManyToMany(mappedBy="pacientes", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Doctor> doctores;

    public Paciente(Integer id, String cedula, String nombre, LocalDate fechaNacimiento) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        
    }

    public Paciente() {

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

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;

    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;

    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente{");
        sb.append("id=").append(id);
        sb.append(", cedula=").append(cedula);
        sb.append(", nombre=").append(nombre);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();

    }

}
