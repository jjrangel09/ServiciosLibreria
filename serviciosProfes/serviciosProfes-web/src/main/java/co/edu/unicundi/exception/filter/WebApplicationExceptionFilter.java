/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.exception.filter;

import co.edu.unicundi.controller.pojo.ErrorWrraper;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS-PC
 */
//Json mal formado
@Provider
public class WebApplicationExceptionFilter implements ExceptionMapper<WebApplicationException>{

    @Override
    public Response toResponse(WebApplicationException ex) {    
        System.out.println("Entro a WebApplicationExceptionFilter");
        ex.printStackTrace();                                
        
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "404", "NOT_FOUND");
        return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
    
} 