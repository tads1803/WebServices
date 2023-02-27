/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.portuary.ws;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author Portuary
 */
@jakarta.ws.rs.ApplicationPath("ws")
public class AplicationResourceConfig extends ResourceConfig {

    public AplicationResourceConfig() {
        super(
            MultiPartFeature.class,
            AplicationResource.class,
            ContainerResource.class,
            MovimentacaoResource.class
        );
    }

}
