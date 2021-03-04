/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author Juan José Rangel
 */
@Entity
@Table(name = "autor")
//@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "Autor.listarTodo", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.listarSinLibros", query = "SELECT a.id, a.nombre, a.apellido, a.fecha FROM Autor a")
})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Autor.listarTodoConsultaNativo", query = "select a.id, a.nombre, a.apellido, a.fecha from public.autor a", resultClass = Autor.class)
})
public class Autor implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    //@NotNull(message = "nombre requerido")
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;

    //@NotNull(message = "apellido requerido")
    @Column(name = "apellido", nullable = false, length = 25)
    private String apellido;

    //@NotNull(message = "fecha requerida")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    //@XmlTransient
    @CascadeOnDelete
    private List<Libro> libro;
    
    //@OneToOne
    @OneToOne(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @CascadeOnDelete
    private Direccion direccion;

    public Autor() {

    }

    public Autor(Integer id, String nombre, String apellido, Date fecha, List<Libro> libro, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.libro = libro;
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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

    public Date getFecha() {
        //DateFormat df = new SimpleDateFormat("yy:MM:dd:HH:mm:ss");
        //return df.format(fecha);
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @JsonIgnore
    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }
}
