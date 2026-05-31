package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="profesor")
@NamedQueries({
    @NamedQuery(name="Profesor.buscarPorGenero", query="SELECT p FROM Profesor p WHERE p.genero = :genero"),
    @NamedQuery(name="Profesor.buscarPorApellido", query="SELECT p FROM Profesor p WHERE p.apellido = :apellido"),
    @NamedQuery(name="Profesor.buscarPorRangoFecha", query="SELECT p FROM Profesor p WHERE p.fechaNacimiento BETWEEN :inicio AND :fin"),
    @NamedQuery(name="Profesor.buscarPorFacultad", query="SELECT p FROM Profesor p WHERE p.facultad = :facultad"),
    @NamedQuery(name="Profesor.buscarPorEspecialidad", query="SELECT p FROM Profesor p WHERE p.especialidad = :especialidad"),
    @NamedQuery(name="Profesor.contar", query="SELECT COUNT(p) FROM Profesor p")
})
public class Profesor {

    @Id
    @SequenceGenerator(name="seq_profesor_generador", sequenceName="seq_profesor", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_profesor_generador")
    @Column(name="prof_id")
    private Integer id;

    @Column(name="prof_nombre")
    private String nombre;

    @Column(name="prof_apellido")
    private String apellido;

    @Column(name="prof_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name="prof_cedula")
    private String cedula;

    @Column(name="prof_genero")
    private String genero;

    @Column(name="prof_facultad")
    private String facultad;

    @Column(name="prof_especialidad")
    private String especialidad;

    public Profesor(Integer id, String nombre, String apellido, LocalDate fechaNacimiento, String cedula, String genero, String facultad, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.genero = genero;
        this.facultad = facultad;
        this.especialidad = especialidad;
    }

    public Profesor() {

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", cedula=" + cedula + ", genero=" + genero
                + ", facultad=" + facultad + ", especialidad=" + especialidad + "]";
    }

}
