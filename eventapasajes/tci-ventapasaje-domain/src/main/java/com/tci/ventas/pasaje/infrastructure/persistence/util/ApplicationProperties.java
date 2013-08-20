package com.tci.ventas.pasaje.infrastructure.persistence.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

/**
 * User: AW
 * Date: 24/02/13
 */
public class ApplicationProperties {

    private final static Logger logger = LoggerFactory.getLogger(ApplicationProperties.class);

    private static Properties props = null;

    private static String appResourcePath= "com/tci/app/application.properties";

    public static Properties getAppPorperties() {

        if(props==null){

            try {
                props = ResourceProperties.getResourcePorperties(appResourcePath);
            } catch (IOException e) {
                logger.error("Error al leer el archivo de propiedades "+appResourcePath,e);
            }
        }
        return  props;
    }



    public static String getExcelTemplatePath() {

        return  getAppPorperties().getProperty("report.excel.template.path");
    }

    public static String getApplicationCode() {

        return  getAppPorperties().getProperty("application.code");
    }

    public static String getProperty(String propertyCode) {

        return  getAppPorperties().getProperty(propertyCode);
    }

}
