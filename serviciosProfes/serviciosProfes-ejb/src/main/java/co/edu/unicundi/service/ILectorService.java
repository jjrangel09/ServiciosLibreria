/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.service;

import co.edu.unicundi.dto.AutorLectorDto;
import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.AutorLector;
import co.edu.unicundi.entity.Lector;
import java.util.List;

/**
 *
 * @author Juan José Rangel <your.name at your.org>
 */
public interface ILectorService {

    public Lector listarPorId(Integer id);

    public List<AutorLectorDto> listarAutorLector(Integer id);

    public void guardar(Lector lector);

    public void asociarAutorLector(AutorLector autorLector);

    public void editar(Lector lector);

    public void eliminar(Integer id);

    public void bloquearUser(Integer id);

    public void desbloquearUser(Integer id);

    public List<Lector> listar();
    
}
