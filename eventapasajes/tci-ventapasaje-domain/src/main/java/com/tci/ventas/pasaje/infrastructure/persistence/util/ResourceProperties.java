package com.tci.ventas.pasaje.infrastructure.persistence.util;

import java.io.IOException;
import java.util.Properties;

/**
 * User: AW
 * Date: 24/02/13
 */
public class ResourceProperties {

    public static Properties getResourcePorperties(String resourcePath) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Properties props = new Properties();

        props.load(classLoader.getResourceAsStream(resourcePath));

        return  props;
    }
}
