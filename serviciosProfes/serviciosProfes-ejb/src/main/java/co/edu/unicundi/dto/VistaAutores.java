/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.dto;

import java.util.Date;

/**
 *
 * @author JuanJ
 */
public class VistaAutores {
    
    private Integer id, autor_id, cantidad_libros;
    private String nombre, apellido, direccion, barrio;
    private Date fecha;

    public VistaAutores() {
    }

    public VistaAutores(Integer id, Integer autor_id, Integer cantidad_libros, String nombre, String apellido, String direccion, String barrio, Date fecha) {
        this.id = id;
        this.autor_id = autor_id;
        this.cantidad_libros = cantidad_libros;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.barrio = barrio;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(Integer autor_id) {
        this.autor_id = autor_id;
    }

    public Integer getCantidad_libros() {
        return cantidad_libros;
    }

    public void setCantidad_libros(Integer cantidad_libros) {
        this.cantidad_libros = cantidad_libros;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
