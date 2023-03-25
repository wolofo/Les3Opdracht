package nl.novi.opdrachten.methodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Gegeven: een lijst met namen zonder hoofdletters van klanten.
 * Opdracht: Een luie stagiair heeft alle klanten in het systeem gezet, maar deze kon de Shift-knop niet vinden.
 * Het is aan jou om alle namen van een hoofdletter aan het begin te voorzien. Maak een methode die een List als
 * parameter ontvangt en de inhoud vervolgens van hoofdletters voorziet.
 *
 * Bonus 1: Zorg ervoor dat tussenvoegsels geen hoofdletter krijgen.
 * Bonus 2: Zorg ervoor dat de eerste letter na een '-' wel een hoofdletter krijgt.
 *
 *
 */

public class Hoofdletters {

    public static void main(String[] args) {
        List<String> customerNames = new ArrayList<>();

        customerNames.add("nick piraat");
        customerNames.add("michael jackson");
        customerNames.add("glennis grace");
        customerNames.add("dreetje hazes");
        customerNames.add("robbie williams");
        customerNames.add("michiel de ruyter");
        customerNames.add("sjaak polak");
        customerNames.add("jan van jansen");
        customerNames.add("henk den hartog");
        customerNames.add("mo el-mecky");
        customerNames.add("fredje kadetje");

        returnStrings(customerNames);

    }

    public static void returnStrings(List<String> names) {

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);

            String[] splitNames = name.split(" ");
            for (int j = 0; j < splitNames.length; j++) {
                if(!isTussenVoegsel(splitNames[j])) {
                    capitalizeString(splitNames[j]);
                }
            }
            name = String.join(" ", splitNames);
            System.out.println(capitalizeString(name));
        }
    }

    public static String capitalizeString(String name) {
        char[] chars = name.toLowerCase().toCharArray();
        boolean previousCharIsLetter = false;
        for (int c = 0; c < chars.length; c++) {
            if (!previousCharIsLetter && Character.isLetter(chars[c])) {
                chars[c] = Character.toUpperCase(chars[c]);
                previousCharIsLetter = true;
            } else if (Character.isWhitespace(chars[c]) || chars[c] == '.' || chars[c] == '\'' || chars[c] == '-' || chars[c] =='d'+'e' || chars[c] == 'v'+'a'+'n') { // You can add other chars here
                previousCharIsLetter = false;
            }

        }
        return String.valueOf(chars);
    }

    public static boolean isTussenVoegsel(String word) {
        List<String> tussenvoegels = Arrays.asList("van", "de", "den");
        for (String tussenvoegsel : tussenvoegels) {
            if (word.equalsIgnoreCase(tussenvoegsel)) {
                return true;
            }
        }
        return false;
    }
}
