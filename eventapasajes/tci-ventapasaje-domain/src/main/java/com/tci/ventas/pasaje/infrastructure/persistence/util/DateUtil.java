package com.tci.ventas.pasaje.infrastructure.persistence.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * User: AW
 * Date: 24/02/13
 */
public class DateUtil {
    public static int DELTA_MILIS = 1000 * 60;

    static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);

    public static Date nvl(Date date1, Date date2) {
        return date1 != null ? date1 : date2;
    }

    public static Date addDaysHoursMins(Date date, Integer dias, Integer horas, Integer minutos) {
        if (date == null) return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (dias != null) cal.add(Calendar.DAY_OF_YEAR, dias);
        if (horas != null) cal.add(Calendar.HOUR_OF_DAY, horas);
        if (minutos != null) cal.add(Calendar.MINUTE, minutos);
        return cal.getTime();
    }

    public static Date min(Date date1, Date date2) {
        if (date1 == null) return date2;
        if (date2 == null) return date1;
        return date1.before(date2) ? date1 : date2;
    }

    public static Date max(Date date1, Date date2) {
        if (date1 == null) return date2;
        if (date2 == null) return date1;
        return date1.after(date2) ? date1 : date2;
    }

    public static Date notNull(Date date, String errorMsg) {
        if (date != null) return date;
        throw new IllegalArgumentException(errorMsg);
    }

    public static boolean inOrder(Date d1, Date d2) {
        if (d1 == null || d2 == null) return false;
        return d1.equals(d2) || !d1.after(d2);
    }

    public static SimpleDateFormat FMT_WEB() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }

    public static String format(SimpleDateFormat dateFormat, Date date) {
        return dateFormat != null && date != null ? dateFormat.format(date) : "";
    }
}
