/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.dto;

import java.io.Serializable;

/**
 *
 * @author Juan José Rangel
 */
public class AutorLectorDto implements Serializable{
    
    private AutorDto autor;

    private LectorDto lector;
    
    private String infoAdicional;

    public AutorDto getAutor() {
        return autor;
    }

    public void setAutor(AutorDto autor) {
        this.autor = autor;
    }

    public LectorDto getLector() {
        return lector;
    }

    public void setLector(LectorDto lector) {
        this.lector = lector;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }        
       
}
