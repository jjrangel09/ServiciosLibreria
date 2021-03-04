/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;


import co.edu.unicundi.dto.AutorLectorDto;
import co.edu.unicundi.entity.Autor;
import co.edu.unicundi.entity.AutorLector;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import co.edu.unicundi.service.IAutorService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/autores")
public class AutorController {

    @EJB
    private IAutorService service;

    @Path("/listar/{filtro}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@PathParam("filtro") Boolean filtro) {
            List<Autor> listarAutor = service.listar(filtro);
            return Response.status(Response.Status.OK).entity(listarAutor).build();
    }
    
    @Path("/listarAutorLector/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarAutorLector() {
            List<AutorLector> listarAutor = service.listarAutorLector();
            return Response.status(Response.Status.OK).entity(listarAutor).build();
    }

    @Path("/retornarPorId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("id") Integer id) throws ObjectNotFoundException {
        Autor autor = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(autor).build();
    }
    
    
    @Path("/listarLector/{idAutor}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarLector(@PathParam("idAutor") Integer id)  {
        List<AutorLectorDto> lista = service.listarAutorLector(id);
        return Response.status(Response.Status.OK).entity(lista).build();       
    }        
    
    @Path("/listarAutor/{idLector}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarAutor(@PathParam("idLector") Integer id)  {
        List<AutorLectorDto> lista = service.listarLectorAutor(id);
        return Response.status(Response.Status.OK).entity(lista).build();       
    }

    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Autor autor) {
        service.guardar(autor);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @Path("/asociarLector")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response asociarLector(AutorLector autorLector) {
        service.asociarAutorLector(autorLector);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @Path("/editar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@Valid Autor autor) throws ParamRequiredException {
        service.editar(autor);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer id) throws ObjectNotFoundException {
        service.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Path("/bloquearUser/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response bloquearUser(@PathParam("id") Integer id) throws ObjectNotFoundException {
        service.bloquearUser(id);
        return Response.status(Response.Status.OK).build();
    }
    
    @Path("/desbloquearUser/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response desbloquearUser(@PathParam("id") Integer id) throws ObjectNotFoundException {
        service.desbloquearUser(id);
        return Response.status(Response.Status.OK).build();
    }
}
