/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ASUS-PC
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.unicundi.controller.AutorController.class);
        resources.add(co.edu.unicundi.controller.LectorController.class);
        resources.add(co.edu.unicundi.controller.LibroController.class);
        resources.add(co.edu.unicundi.exception.filter.BadRequestExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.ConstraintViolationFilter.class);
        resources.add(co.edu.unicundi.exception.filter.ExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.NotAllowedExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.NotFoundExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.NotSupportedExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.NullPointerExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.ObjectNotFoundExceptionFilter.class);
        resources.add(co.edu.unicundi.exception.filter.WebApplicationExceptionFilter.class);
        resources.add(org.netbeans.rest.application.config.Cors.class);
    }
    
}
