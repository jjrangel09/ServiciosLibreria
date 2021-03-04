/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo.impl;

import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.repo.IAutorRepo;
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
public class AutorRepo implements IAutorRepo {

    @PersistenceContext(unitName = "co.edu.unicundi_serviciosProfes-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager entity;

    @Override
    public List<Autor> listar(boolean filtro) {
        if (filtro) {
            TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodo", Autor.class);
            //TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodoConsultaNativo", Autor.class);
            return listaAutor.getResultList();
        } else {
            TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarSinLibros", Autor.class);
           // TypedQuery<Autor> listaAutor = this.entity.createNamedQuery("Autor.listarTodoConsultaNativo", Autor.class);
            return listaAutor.getResultList();
        }
    }

    @Override
    public Autor listarPorId(Integer id) {
        return this.entity.find(Autor.class, id);
    }

    @Override
    public void guardar(Autor autor) {
        this.entity.persist(autor);
    }

    @Override
    public void editar(Autor autor) {
        this.entity.merge(autor);
    }

    @Override
    public void eliminar(Autor autor) {
        if (autor == null) {
            System.err.println("El autor no existe");
        } else if (autor.getLibro().size() == 0) {
            this.entity.remove(autor);
        } else {
            System.out.println("Elimine los libros asociados al autor e intente de nuevo");
            System.out.println(autor.getLibro().size());
        }
    }

}
