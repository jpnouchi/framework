package com.tci.ventas.pasaje.infrastructure.persistence.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * User: AW
 * Date: 24/02/13
 */
public class FormatUtil {
    public final static String FORMAT_NUMERIC="###,###,##0";
    public final static String FORMAT_TEXT="@";
    public final static String FORMAT_NUMERIC_INTEGER="###,###,##0";
    public final static String FORMATO_FECHA_SEPARADOR = "dd/MM/yyyy";
    public final static int SCALE = 4;
    public final static String SCALE_2_FORMAT = "###,###,##0.00";
    public final static String SCALE_4_FORMAT = "###,###,##0.0000";

    public static String format(Date fecha, String pattern) {
        if (fecha == null) {
            return null;
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.format(fecha);
        }
    }

    public static BigDecimal dividir(BigDecimal param1, BigDecimal param2) {
        if (param2 == null || BigDecimal.ZERO.compareTo(param2) == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal valor1 = param1 == null ? BigDecimal.ZERO : param1;
        BigDecimal valor2 = param2 == null ? BigDecimal.ZERO : param2;

        return valor1.divide(valor2, FormatUtil.SCALE, RoundingMode.HALF_UP);

    }

    public static BigDecimal multiplicar(BigDecimal param1, BigDecimal param2) {

        BigDecimal valor1 = param1 == null ? BigDecimal.ZERO : param1;
        BigDecimal valor2 = param2 == null ? BigDecimal.ZERO : param2;

        return valor1.multiply(valor2);
    }

    public static String formatFull(Date date) {
        return date == null ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String getStringFormatForTwoDecimalsAndMoneda(BigDecimal number, String monedaSimbolo) {
        String montoAsString = getStringValueByFormat(number, SCALE_4_FORMAT, Locale.US);
        String moneda = StringUtils.hasText(monedaSimbolo) ? monedaSimbolo : "";
        return StringUtils.hasText(montoAsString) ?  moneda + " " + montoAsString : "";
    }

    public static String getStringValueByFormatAndLocaleUS(BigDecimal number, String format) {
        return getStringValueByFormat(number, format, Locale.US);
    }

    public static String getStringValueByFormat(BigDecimal number, String format, Locale locale) {
        String formatNumber = "";
        if (number != null && locale != null && StringUtils.hasText(format)) {
            DecimalFormat decimalFormat = new DecimalFormat(format);
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(locale));
            formatNumber = decimalFormat.format(number);
        }
        return formatNumber;
    }

    public static String currencyFormat(BigDecimal n) {
        return NumberFormat.getCurrencyInstance().format(n);
    }
}
