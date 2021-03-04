/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo.impl;

import co.edu.unicundi.entity.Libro;
import co.edu.unicundi.repo.AbstractFacade;
import co.edu.unicundi.repo.ILibroRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
@Stateless
public class LibroRepoImpl extends AbstractFacade<Libro, Integer>  implements ILibroRepo{
    
    @PersistenceContext(unitName = "co.edu.unicundi_serviciosProfes-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    public LibroRepoImpl() {
        super(Libro.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return entity;
    }        

    @Override
    public List<Libro> listar() {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        TypedQuery<Libro> listaAutor = this.entity.createNamedQuery("Libro.listarTodo", Libro.class);                
        return listaAutor.getResultList();        
    }

    @Override
    public Integer cantidadTotal() {
        this.entity.getEntityManagerFactory().getCache().evictAll();
        Query query = this.entity.createNamedQuery("Libro.cantidadTotal", Integer.class);      
        Integer total = Integer.parseInt(query.getSingleResult().toString());
        return total;                
    }

}
