
package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Érica_Almeida
 */
public class DataUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate stringParaLocalDate(String data) throws DateTimeParseException {
        return LocalDate.parse(data, FORMATTER);
    }

    public static String localDateParaString(LocalDate data) {
        return data.format(FORMATTER);
    }
}