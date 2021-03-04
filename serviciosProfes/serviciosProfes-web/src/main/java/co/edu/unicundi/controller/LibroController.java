/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;



import co.edu.unicundi.dto.LibroDto;
import co.edu.unicundi.dto.LibroPaginadoDto;
import co.edu.unicundi.entity.Libro;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import co.edu.unicundi.service.ILibroService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Juan José Rangel
 */
@Stateless
@Path("/libros")
public class LibroController {

    @EJB
    private ILibroService service;
    
    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar()  {
        List<LibroDto> listarLibro = service.listar();
        return Response.status(Response.Status.OK).entity(listarLibro).build();       
    }        

    @Path("/retornarPorId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("id" ) Integer id) throws ObjectNotFoundException {
        LibroDto libro = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(libro).build();       
    }      
    
    @Path("/retornarPaginado/{page}/{size}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("page") Integer page, @PathParam("size") Integer size)  {
        LibroPaginadoDto lista = service.listarPaginado(page, size);
        return Response.status(Response.Status.OK).entity(lista).build();       
    }      
    
    
    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Libro libro) throws ParamRequiredException {
        service.guardar(libro);
        return Response.status(Response.Status.CREATED).build();
    }    
    
    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer id) throws ObjectNotFoundException {
        service.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
}
