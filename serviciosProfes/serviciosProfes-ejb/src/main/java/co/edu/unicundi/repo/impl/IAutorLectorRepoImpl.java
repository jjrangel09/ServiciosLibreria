/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo.impl;

import co.edu.unicundi.entity.AutorLector;
import co.edu.unicundi.repo.IAutorLectorRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
@Stateless
public class IAutorLectorRepoImpl implements IAutorLectorRepo {

    @PersistenceContext(unitName = "co.edu.unicundi_serviciosProfes-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    @Override
    public void guardar(AutorLector autorLector) {
        entity.persist(autorLector);
    }

    @Override
    public List<AutorLector> listarAutorLector(Integer idAutor) {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<AutorLector> listaAutorLector = this.entity.createNamedQuery("AutorLector.listarLectorPorAutor", AutorLector.class);
        listaAutorLector.setParameter("idAutor", idAutor);
        return listaAutorLector.getResultList();
    }

    @Override
    public List<AutorLector> listarLectorAutor(Integer idLector) {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<AutorLector> listaAutorLector = this.entity.createNamedQuery("AutorLector.listarAutorPorLector", AutorLector.class);
        listaAutorLector.setParameter("idLector", idLector);
        return listaAutorLector.getResultList();
    }

    @Override
    public List<AutorLector> listarAutorLector() {
        TypedQuery<AutorLector> listaAutorLector = this.entity.createNamedQuery("AutorLector.listarTodo", AutorLector.class);
        return listaAutorLector.getResultList();
    }

}
