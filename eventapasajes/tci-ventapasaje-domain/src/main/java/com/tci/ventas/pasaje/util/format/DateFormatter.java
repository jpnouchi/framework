package com.tci.ventas.pasaje.util.format;

import com.tci.exception.TciSystemException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: AW
 * Date: 24/02/13
 */
public class DateFormatter implements Formatter<Date> {

    public static final Formatter<Date> DATE_FORMATTER = new DateFormatter("dd/MM/yyyy");
    public static final Formatter<Date> DATE_TIME_FORMATTER = new DateFormatter("dd/MM/yyyy HH:mm");
    public static final Formatter<Date> TIME_FORMATTER = new DateFormatter("HH:mm");
    public static final Formatter<Date> DATE_TIME_FORMAT =new DateFormatter("dd/MM/yyyy HH:mm:ss");

    private SimpleDateFormat format = null;

    public DateFormatter(String formatPattern) {
        this.format = new SimpleDateFormat(formatPattern);
    }


    public String print(Date value) {
        return format.format(value);
    }

    public Date parse(String text)  {
        if ("".equals(text)) {
            return null;
        }
        try {
            return format.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new TciSystemException("Problemas parseando:"+text,e);
        }
    }


}
