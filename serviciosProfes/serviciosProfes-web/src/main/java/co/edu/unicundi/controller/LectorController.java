/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.controller;

import co.edu.unicundi.dto.AutorLectorDto;
import co.edu.unicundi.entity.AutorLector;
import co.edu.unicundi.entity.Lector;
import co.edu.unicundi.exception.ObjectNotFoundException;
import co.edu.unicundi.exception.ParamRequiredException;
import co.edu.unicundi.service.ILectorService;
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
 * @author Juan José Rangel <your.name at your.org>
 */
@Stateless
@Path("/Lectores")
public class LectorController {
    @EJB
    private ILectorService service;

    @Path("/listar/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
            List<Lector> listarLector = service.listar();
            return Response.status(Response.Status.OK).entity(listarLector).build();
    }
    

    @Path("/retornarPorId/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response retornarPorId(@PathParam("id") Integer id) throws ObjectNotFoundException {
        Lector lector = service.listarPorId(id);
        return Response.status(Response.Status.OK).entity(lector).build();
    }
    
    
    @Path("/listarLector/{idLector}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarLector(@PathParam("idLector") Integer id)  {
        List<AutorLectorDto> lista = service.listarAutorLector(id);
        return Response.status(Response.Status.OK).entity(lista).build();       
    }        
    

    @Path("/guardar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(@Valid Lector lector) {
        service.guardar(lector);
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
    public Response editar(@Valid Lector lector) throws ParamRequiredException {
        service.editar(lector);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/eliminar/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Integer id) throws ObjectNotFoundException {
        service.eliminar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
