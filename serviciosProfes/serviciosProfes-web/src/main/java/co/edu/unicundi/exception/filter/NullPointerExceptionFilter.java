/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.exception.filter;

import co.edu.unicundi.controller.pojo.ErrorWrraper;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS-PC
 */
@Provider
public class NullPointerExceptionFilter implements ExceptionMapper<NullPointerException>{

    @Override
    public Response toResponse(NullPointerException ex) {       
        System.out.println("Entro a NullPointerExceptionFilter");
        ex.printStackTrace();                                
        
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "500", "INTERNAL_SERVER_ERROR");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
    }
    
}
