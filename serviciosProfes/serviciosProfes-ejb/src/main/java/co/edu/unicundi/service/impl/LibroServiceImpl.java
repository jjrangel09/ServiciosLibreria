/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service.impl;

import co.edu.unicundi.dto.LibroDto;
import co.edu.unicundi.dto.LibroPaginadoDto;
import co.edu.unicundi.entity.Libro;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import co.edu.unicundi.repo.ILibroRepo;
import co.edu.unicundi.service.ILibroService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.modelmapper.ModelMapper;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
@Stateless
public class LibroServiceImpl implements ILibroService {

    @EJB
    private ILibroRepo repo;
    
    @Override
    public List<LibroDto> listar() {
        List<Libro> listaLibro = repo.listar();
        List<LibroDto> libroDto = new ArrayList<>();
        
        for (Libro libro: listaLibro) {
            ModelMapper modelMapper = new ModelMapper();
            LibroDto dto = modelMapper.map(libro, LibroDto.class);   
            libroDto.add(dto);            
        }
        
        for (LibroDto dto : libroDto) {
            //dto.setAutor(null);
            dto.getAutor().getLibro().clear();
        }
        
        return libroDto;
    }

    @Override
    public LibroDto listarPorId(Integer id) throws ObjectNotFoundException {
        Libro libro =  repo.listarPorId(id);
        
        if(libro == null)
            throw new ObjectNotFoundException("Libro no existe.");
        
        ModelMapper modelMapper = new ModelMapper();
        LibroDto dto = modelMapper.map(libro, LibroDto.class);   
        
        //dto.setAutor(null);
        dto.getAutor().getLibro().clear();
        
        return dto;
    }

    @Override
    public void guardar(Libro libro) throws ParamRequiredException {
         if(libro.getAutor() == null || libro.getAutor().getId() == null) {
             throw new ParamRequiredException("IdAutor es requerido para guardar");
         }  else {
             //libro.getAutor().getLibro().add(libro);
             repo.guardar(libro);
         }
    }

    @Override
    public void editar(Libro libro) throws ParamRequiredException, ObjectNotFoundException {
        if(libro.getId() == null)
            throw new ParamRequiredException("Id es requerido para edición");
        
        Libro libroAux = repo.listarPorId(libro.getId());
        
        if(libroAux == null)
            throw new ObjectNotFoundException("Libro no existe.");
        
        libroAux.setEditorial(libro.getEditorial());
        libroAux.setNombre(libro.getNombre());
        
        //libroAux.setAutor(libro.getAutor());  No funciona
        repo.editar(libroAux);
    }

    @Override
    public void eliminar(Integer idLibro) throws  ObjectNotFoundException {
         Libro libroAux = repo.listarPorId(idLibro);
         
        if(libroAux == null)
            throw new ObjectNotFoundException("Libro no existe.");
         
        repo.eliminar(libroAux);
    }

    @Override
    public LibroPaginadoDto listarPaginado(int page, int size) {
        List<Libro> listaLibro = repo.listarPaginado(page, size);
        List<LibroDto> libroDto = new ArrayList<>();
        
        for (Libro libro: listaLibro) {
            ModelMapper modelMapper = new ModelMapper();
            LibroDto dto = modelMapper.map(libro, LibroDto.class);   
            libroDto.add(dto);            
        }
        
        for (LibroDto dto : libroDto) {
            //dto.setAutor(null);
            dto.getAutor().getLibro().clear();
        }
        
        LibroPaginadoDto paginado = new LibroPaginadoDto();
        paginado.setContent(libroDto);
        paginado.setCantidad(repo.cantidadTotal());
        
        return paginado;
        
    }
    
}
