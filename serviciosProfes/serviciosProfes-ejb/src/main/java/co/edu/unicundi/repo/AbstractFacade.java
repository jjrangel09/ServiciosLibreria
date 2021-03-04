/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 * @param <T>
 * @param <V>
 */
public abstract class AbstractFacade<T, V> {
      
    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();    
    
    public List<T> listar() {
        CriteriaQuery query =  getEntityManager().getCriteriaBuilder().createQuery();
        query.select(query.from(entityClass));
        Query q = getEntityManager().createQuery(query);
        return q.getResultList();
    }
    
    public List<T> listarPaginado(int page, int size) {
        CriteriaQuery query =  getEntityManager().getCriteriaBuilder().createQuery();
        query.select(query.from(entityClass));
        Query q = getEntityManager().createQuery(query);
        q.setFirstResult((page -1) * size);
        q.setMaxResults(size);
        return q.getResultList();
    }
    
    
    public T listarPorId(V id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public void guardar(T entity) {
        getEntityManager().persist(entity);
    }
    
    public void editar(T entity) {
         getEntityManager().merge(entity);
    }
   
    public void eliminar(T entity) {
        getEntityManager().remove(entity);
    }
    
    
}
