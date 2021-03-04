/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.exception.filter;

import co.edu.unicundi.controller.pojo.ErrorWrraper;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ASUS-PC
 */
//Es Get y se envia POST con o sin raw
@Provider
public class NotAllowedExceptionFilter implements ExceptionMapper<NotAllowedException> {

    @Override
    public Response toResponse(NotAllowedException ex) {
        System.out.println("Entro a NotAllowedExceptionFilter");
        ex.printStackTrace();                        
        ErrorWrraper error = new ErrorWrraper(ex.getMessage(), "405", "METHOD_NOT_ALLOWED");
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(error).build();
    }
}