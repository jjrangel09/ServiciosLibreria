/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo;

import co.edu.unicundi.entity.AutorLector;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
@Local
public interface IAutorLectorRepo {
    
    public void guardar(AutorLector autorLector);
    
    public List<AutorLector> listarAutorLector(Integer idAutor);
    
    public List<AutorLector> listarLectorAutor(Integer idLector);

    public List<AutorLector> listarAutorLector();
    
}
