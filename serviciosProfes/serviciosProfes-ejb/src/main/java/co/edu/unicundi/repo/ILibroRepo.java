/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo;

import co.edu.unicundi.entity.Libro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
@Local
public interface ILibroRepo {
    
    public List<Libro> listar();
        
    public Libro listarPorId(Integer id);
    
    public Integer cantidadTotal();
    
    public List<Libro> listarPaginado(int page, int size);
    
    public void guardar(Libro libro);
    
    public void editar(Libro libro);
   
    public void eliminar(Libro libro);
        
}
