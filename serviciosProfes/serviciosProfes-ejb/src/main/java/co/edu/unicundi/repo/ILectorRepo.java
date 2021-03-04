/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.repo;

import co.edu.unicundi.entity.Lector;
import java.util.List;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
public interface ILectorRepo {

    public Lector listarPorId(Integer id);

    public List<Lector> listar();
    
}
