/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portuary.ws;

import com.portuary.dao.ConnectionFactory;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Portuary
 */
public class ContextListener implements ServletContextListener {

    protected final org.apache.log4j.Logger logger = LogManager.getLogger(getClass());
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        logger.info("WebServices ServletContextListener starting...");
        
        // Responsável por configurar a biblioteca de logs
        ConfigureLog4j();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        // Responsável por encerrar o pool de conexões com Banco de Dados
        FinalizeDataBasePool();
        
        logger.info("WebServices ServletContextListener destroyed");
    }
    
    /**
     * Responsável por configurar a biblioteca de logs
     */
    private void ConfigureLog4j(){
        try {
            URL url = getClass().getResource("/log4j.properties");
            String log4jConfigFile = url.toURI().getPath();
            PropertyConfigurator.configure(log4jConfigFile);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Responsável por encerrar o pool de conexões com Banco de Dados
     */
    private void FinalizeDataBasePool(){
        try { 
            ConnectionFactory.getInstance().stopDatabasePool();
        } catch (RuntimeException ex) { 
            logger.error("Não foi possível parar a thread do pool de conexão: " + ex.getMessage());
        } catch (Exception ex) { 
            logger.error("Não foi possível parar a thread do pool de conexão: " + ex.getMessage());
        } catch (Throwable ex) { 
            logger.error("Não foi possível parar a thread do pool de conexão: " + ex.getMessage());
        }
    }
}
