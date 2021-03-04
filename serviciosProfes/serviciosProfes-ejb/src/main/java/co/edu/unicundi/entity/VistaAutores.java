/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author JuanJ
 */

@Entity
@Table(name = "vista_autores")
@NamedNativeQueries({
    //@NamedQuery(name "vistaAutores.listar", query = "SELECT a.* from vista_autores", resultClass),
    //@NamedQuery(name "vistaAutores.listarAutor", query = "SELECT a.* from vista_autores")
})
public class VistaAutores implements Serializable {
    
    @Id
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column
    private Integer autor_id;
    @Column
    private String direccion;
    @Column
    private String Barrio;

    public VistaAutores() {
    }

    public VistaAutores(Integer id, String nombre, String apellido, Date fecha, Integer autor_id, String direccion, String Barrio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.autor_id = autor_id;
        this.direccion = direccion;
        this.Barrio = Barrio;
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
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Integer autor_id) {
        this.autor_id = autor_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return Barrio;
    }

    public void setBarrio(String Barrio) {
        this.Barrio = Barrio;
    }
    
    
}
