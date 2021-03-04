/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service;

import co.edu.unicundi.dto.LibroDto;
import co.edu.unicundi.dto.LibroPaginadoDto;
import co.edu.unicundi.entity.Libro;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
@Local
public interface ILibroService {
    
    public List<LibroDto> listar();
    
    public LibroPaginadoDto listarPaginado(int page, int size);
        
    public LibroDto listarPorId(Integer id) throws ObjectNotFoundException;
    
    public void guardar(Libro libro) throws ParamRequiredException;
    
    public void editar(Libro libro) throws ParamRequiredException ,ObjectNotFoundException;
   
    public void eliminar(Integer idLibro) throws ObjectNotFoundException;
    
}
