package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="director")
public class Director {

    @Id
    @SequenceGenerator(name="seq_director_generador", sequenceName="seq_director", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_director_generador")
    @Column(name="dire_id")
    private Integer id;

    @Column(name="dire_nombre")
    private String nombre;

    @Column(name="dire_nacionalidad")
    private String nacionalidad;

    @OneToMany(mappedBy="director", cascade=CascadeType.ALL)
    private List<Pelicula> peliculas;

    public Director(Integer id, String nacionalidad, String nombre) {
        this.id = id;
        this.nacionalidad = nacionalidad;
        this.nombre = nombre;
    }

    public Director() {

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

    public String getNacionalidad() {
        return nacionalidad;

    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;

    }

    public List<Pelicula> getPeliculas() {
        return peliculas;

    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Director{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", nacionalidad=").append(nacionalidad);
        sb.append(", peliculas=").append(peliculas);
        sb.append('}');
        return sb.toString();

    }

}
