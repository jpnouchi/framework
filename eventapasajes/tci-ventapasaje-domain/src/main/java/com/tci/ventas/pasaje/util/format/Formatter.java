package com.tci.ventas.pasaje.util.format;

/**
 * User: AW
 * Date: 24/02/13
 */
public interface Formatter<T> {

    String print(T value);

    T parse(String text);
}
