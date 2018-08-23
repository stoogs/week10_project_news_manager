package models;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class DateFormater {
    public static void main(String[] args) {
        DateTimeFormatter nTZ = DateTimeFormatter.ofPattern("d MMMM, yyyy h:mm a");
        System.out.println(ZonedDateTime.now().format(nTZ));
    }
}
