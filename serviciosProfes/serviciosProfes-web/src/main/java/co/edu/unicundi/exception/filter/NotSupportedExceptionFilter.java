/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.exception.filter;

import co.edu.unicundi.controller.pojo.ErrorWrraper;
import javax.ws.rs.NotSupportedException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS-PC
 */
//Se enviea no Json
@Provider
public class NotSupportedExceptionFilter implements ExceptionMapper<NotSupportedException>{

    @Override
    public Response toResponse(NotSupportedException ex) {    
        System.out.println("Entro a NotSupportedException");
        ex.printStackTrace();                                
        
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "415", "UNSUPPORTED_MEDIA_TYPE");
        return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity(error).build();
    }
    
} 