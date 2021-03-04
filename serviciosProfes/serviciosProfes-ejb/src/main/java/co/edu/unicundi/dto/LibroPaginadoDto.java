/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Juan José Rangel
 */
public class LibroPaginadoDto implements Serializable{
    
    private Integer cantidad;
    
    private List<LibroDto> content;

    public LibroPaginadoDto(Integer cantidad, List<LibroDto> content) {
        this.cantidad = cantidad;
        this.content = content;
    }

    public LibroPaginadoDto() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<LibroDto> getContent() {
        return content;
    }

    public void setContent(List<LibroDto> content) {
        this.content = content;
    }
    
    
    
}
