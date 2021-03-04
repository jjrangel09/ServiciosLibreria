/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service.impl;

import co.edu.unicundi.dto.AutorLectorDto;
import co.edu.unicundi.entity.AutorLector;
import co.edu.unicundi.entity.Lector;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.repo.ILectorRepo;
import co.edu.unicundi.service.ILectorService;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
public class LectorServiceImpl implements ILectorService {

    @EJB
    private ILectorRepo repo;

    @Override
    public Lector listarPorId(Integer id) {
        Lector lector = repo.listarPorId(id);
        if (lector == null) {
            throw new ObjectNotFoundException("Autor no existe.");
        } else {
            return lector;
        }
    }

    @Override
    public List<AutorLectorDto> listarAutorLector(Integer id) {
        Lector lector = repo.listarPorId(id);
        if (lector == null) {
            throw new ObjectNotFoundException("Autor no existe.");
        } else {
          //  return lector;
          return null;
        }
    }

    @Override
    public void guardar(Lector lector) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asociarAutorLector(AutorLector autorLector) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Lector lector) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bloquearUser(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desbloquearUser(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lector> listar() {
        return repo.listar();
    }

}
