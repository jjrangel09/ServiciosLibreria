/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;



/**
 *
 * @author Juan José Rangel
 */
@Entity
@Table(name = "libro")
@NamedQueries({
    @NamedQuery(name = "Libro.listarTodo", query = "SELECT a FROM Libro a"),           
    @NamedQuery(name = "Libro.cantidadTotal", query = "SELECT COUNT(a) FROM Libro a")
})
public class Libro implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    
    @Column(name = "editorial", nullable = false, length = 15)
    private String editorial;
    
    
    @JoinColumn(name = "id_autor", nullable = false)
    @ManyToOne
    @XmlInverseReference(mappedBy="id")
    private Autor autor;

    public Libro() {
    
    }
    
    public Libro(Integer id, String nombre, String editorial, Autor autor) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @JsonIgnore
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
