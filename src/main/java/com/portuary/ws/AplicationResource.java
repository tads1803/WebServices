/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portuary.ws;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * REST Web Service
 *
 * @author Portuary
 */
@Path("app")
public class AplicationResource {

    @Context
    private UriInfo context;
    protected final Logger logger = LogManager.getLogger(getClass());
    
    @Path("/public/version")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Response version() {
        try {
            return Response.status(Response.Status.OK).entity("1.0.1").build();
        } catch (Exception e) {
            logger.error("Erro ao tentar obter os dados! " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro desconhecido ao tentar obter os dados!").build();
        }
    }
    
}
