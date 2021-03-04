/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service.impl;

import co.edu.unicundi.dto.AutorLectorDto;
import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.AutorLector;
import co.edu.unicundi.entity.Libro;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import co.edu.unicundi.repo.IAutorLectorRepo;
import co.edu.unicundi.repo.IAutorRepo;
import co.edu.unicundi.service.IAutorService;
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
public class AutorServiceImp implements IAutorService {

    @EJB
    private IAutorRepo repo;

    @EJB
    private IAutorLectorRepo repoAutorLector;

    @Override
    public List<Autor> listar(boolean filtro) {
        return repo.listar(filtro);
    }
    
     @Override
    public List<AutorLector> listarAutorLector() {
        return repoAutorLector.listarAutorLector();
    }

    @Override
    public Autor listarPorId(Integer id) throws ObjectNotFoundException {
        Autor autor = repo.listarPorId(id);
        if (autor == null) {
            throw new ObjectNotFoundException("Autor no existe.");
        } else {
            return autor;
        }
    }

    @Override
    public void guardar(Autor autor) {
        if (autor.getLibro() != null) {
            for (Libro libro : autor.getLibro()) {
                libro.setAutor(autor);
            }
        }
        repo.guardar(autor);
    }

    @Override
    public void editar(Autor autor) throws ParamRequiredException {
        if (autor.getId() == null) {
            throw new ParamRequiredException("Id requerido");
        } else {
            Autor autorEdit = repo.listarPorId(autor.getId());
            autorEdit.setNombre(autor.getNombre());
            autorEdit.setApellido(autor.getApellido());
            autorEdit.setFecha(autor.getFecha());
            autorEdit.setLibro(autor.getLibro());
            autorEdit.setDireccion(autor.getDireccion());
            repo.editar(autorEdit);
        }

    }

    @Override
    public void eliminar(Integer id) throws ObjectNotFoundException {

        Autor autor = this.listarPorId(id);
        repo.eliminar(autor);

    }

    @Override
    public void bloquearUser(Integer id) {
        //repo.bloquear(id);
    }

    @Override
    public void desbloquearUser(Integer id) {
        //repo.desbloquear(autor);
    }

    @Override
    public void asociarAutorLector(AutorLector autorLector) {
        repoAutorLector.guardar(autorLector);
    }

    @Override
    public List<AutorLectorDto> listarAutorLector(Integer idAutor) {
        List<AutorLector> listaAutorLector = repoAutorLector.listarAutorLector(idAutor);
        List<AutorLectorDto> lista = new ArrayList<>();
        for (AutorLector lis : listaAutorLector) {
            ModelMapper modelMapper = new ModelMapper();
            AutorLectorDto autorLectorDto = modelMapper.map(lis, AutorLectorDto.class);   
            //autorLectorDto.getAutor().setLibro(null);
            autorLectorDto.setAutor(null);
            lista.add(autorLectorDto);            
        }        
        return lista;
    }

    @Override
    public List<AutorLectorDto> listarLectorAutor(Integer idLector) {
        List<AutorLector> listaAutorLector = repoAutorLector.listarAutorLector(idLector);
        List<AutorLectorDto> lista = new ArrayList<>();
        for (AutorLector lis : listaAutorLector) {
            ModelMapper modelMapper = new ModelMapper();
            AutorLectorDto autorLectorDto = modelMapper.map(lis, AutorLectorDto.class);   
            //autorLectorDto.getAutor().setLibro(null);
            autorLectorDto.setAutor(null);
            lista.add(autorLectorDto);            
        }        
        return lista;
    }

   
}
