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
@Table(name="pelicula")
public class Pelicula {

    @Id
    @SequenceGenerator(name="seq_pelicula_generador", sequenceName="seq_pelicula", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_pelicula_generador")
    @Column(name="peli_id")
    private Integer id;

    @Column(name="peli_titulo")
    private String titulo;

    @Column(name="peli_fecha_estreno")
    private LocalDate fechaEstreno;

    @ManyToOne
    @JoinColumn(name="peli_director")
    private Director director;

    public Pelicula(Integer id, String titulo, LocalDate fechaEstreno) {
        this.id = id;
        this.titulo = titulo;
        this.fechaEstreno = fechaEstreno;
        
    }

    public Pelicula() {

    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getTitulo() {
        return titulo;

    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;

    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;

    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;

    }

    public Director getDirector() {
        return director;

    }

    public void setDirector(Director director) {
        this.director = director;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{");
        sb.append("id=").append(id);
        sb.append(", titulo=").append(titulo);
        sb.append(", fechaEstreno=").append(fechaEstreno);
        sb.append(", director=").append(director);
        sb.append('}');
        return sb.toString();
    }

}
