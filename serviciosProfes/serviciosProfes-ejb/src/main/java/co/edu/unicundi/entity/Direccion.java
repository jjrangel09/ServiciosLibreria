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
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Juan José Rangel
 */
@Entity
@Table(name = "direccion")
@NamedQueries({
    @NamedQuery(name = "Direccion.listarTodo", query = "SELECT a FROM Direccion a")
})
public class Direccion implements Serializable{
    
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    
    //@NotNull(message = "Dirección requerida")
    @Column(name = "direccion", nullable = false, length = 70)
    private String direccion;
    
    //@NotNull(message = "Barrio requerido")
    @Column(name = "barrio", nullable = false, length = 25)
    private String barrio;
    
    //@MapsId
    @JoinColumn(name = "id_autor", nullable = false)
    //@OneToOne(mappedBy = "id")
    @OneToOne
    //@XmlTransient
    private Autor autor;

    public Direccion() {
        
    }

    public Direccion(Integer id, String direccion, String barrio, Autor autor) {
        this.id = id;
        this.direccion = direccion;
        this.barrio = barrio;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }        
    
}
