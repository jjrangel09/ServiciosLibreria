/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service;

import co.edu.unicundi.dto.AutorLectorDto;
import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.AutorLector;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
@Local
public interface IAutorService {
    
    public List<Autor> listar(boolean filtro);
    
    public Autor listarPorId(Integer id) throws ObjectNotFoundException;
    
    public void guardar(Autor autor);
    
    public void editar(Autor autor) throws ParamRequiredException;
   
    public void eliminar(Integer id) throws  ObjectNotFoundException;

    public void bloquearUser(Integer id);

    public void desbloquearUser(Integer id);
    
    public void asociarAutorLector(AutorLector autorLector);
    
    public List<AutorLectorDto> listarAutorLector(Integer idAutor);
    
    public List<AutorLectorDto> listarLectorAutor(Integer idLector);

    public List<AutorLector> listarAutorLector();
    
}
