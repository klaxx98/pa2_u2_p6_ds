package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor {

    @Id
    @SequenceGenerator(name="seq_doctor_generador", sequenceName="seq_doctor", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_doctor_generador")
    @Column(name="doct_id")
    private Integer id;

    @Column(name="doct_nombre")
    private String nombre;

    @Column(name="doct_especialidad")
    private String especialidad;

    @Column(name="doct_consultorio")
    private String consultorio;

    @ManyToMany
    @JoinTable(name="doctor_paciente",
                joinColumns=@JoinColumn(name="dopa_id_doctor"),
                inverseJoinColumns=@JoinColumn(name="dopa_id_paciente")
    )
    private List<Paciente> pacientes;

    public Doctor(Integer id, String nombre, String especialidad, String consultorio) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        
    }

    public Doctor() {

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

    public String getEspecialidad() {
        return especialidad;

    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;

    }

    public String getConsultorio() {
        return consultorio;

    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;

    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Doctor{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", especialidad=").append(especialidad);
        sb.append(", consultorio=").append(consultorio);
        sb.append('}');
        return sb.toString();

    }

}
