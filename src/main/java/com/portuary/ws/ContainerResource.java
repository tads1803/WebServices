/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portuary.ws;

import com.portuary.bo.Container_BO;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Portuary
 */
@Path("container")
public class ContainerResource {

    @Context
    private UriInfo context;
    protected final Logger logger = LogManager.getLogger(getClass());
    
    @Path("/public/getRelByCat")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response GetRelatorioByCategoria(String dados) {
        try {
            // Solicita o relatório
            JSONObject resp = (new Container_BO()).GetRelatorioByCategoria(dados);
            // Retorna os dados ao frontEnd
            return Response.status(Response.Status.OK).entity(resp.toString()).build();
        } catch (Exception e) {
            logger.error("Erro ao tentar obter os dados! " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro desconhecido ao tentar obter os dados!").build();
        }
    }
    
}
