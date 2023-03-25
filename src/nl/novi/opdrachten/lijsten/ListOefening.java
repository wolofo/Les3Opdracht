package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOefening {

    public static void main(String[] uitlegList) {

        //We hebben een list die de namen van voetbalclubs bevat
        List<String> clubNames = new ArrayList<>();
        //Die vullen we alvast voor de opdracht
        clubNames.add("Ajax");
        clubNames.add("PSV");
        clubNames.add("Feyenoord");
        clubNames.add("Fc Utrecht");
        clubNames.add("Fc Groningen");
        clubNames.add("FC Twente");

        printClubsList(clubNames);

        printClubsAndPosition(clubNames);

        addClub(clubNames, "Heracles");
        System.out.println(clubNames);

        int position = positionInList(clubNames, "Ajax");
        System.out.println(position);

        clubNames.add("Zlotty FC");
        clubNames.add("SC Eindhoven");
        clubNames.add("PA");
        clubNames.add("AA Aachen");
        clubNames.add("AFC Amsterdam");
        clubNames.add("AFC");
        alphabeticalOrderClubsAndAjaxFirst(clubNames);
        System.out.println(clubNames);


        alphabeticalOrderClubsAndPSVLast(clubNames);
        System.out.println(clubNames);
    }


    // Vraag -1: Maak een methode die al taak heeft om de list per regel uit te printen.
    private static void printClubsList(List<String> clubNames) {
        for (String club : clubNames) {
            System.out.println(club);
        }
    }

    // Vraag 0: Maak een methode die als taak heeft om de list uit te printen: positie + inhoud.
    // Bovenstaande list zou dan dit zijn:
    // 0 - Ajax
    // 1 - PSv
    // etc...
    private static void printClubsAndPosition(List<String> position) {
        for (int p = 0; p < position.size(); p++) {
            System.out.println(p + " - " + position.get(p));
        }
    }

    // Vraag 1: Maak een methode die checkt of een club al in de lijst zit en voeg deze anders toe.
    private static List<String> addClub(List<String> clubNames, String club) {
        boolean isUnique = true;
        for (String clubName : clubNames) {
            if (club.equalsIgnoreCase(clubName)) {
                isUnique = false;
                break;
            }
        }
        if (isUnique) {
            clubNames.add(club);
        }
        return clubNames;
    }

    // Vraag 2: Maak een methode die de positie van de club in de lijst teruggeeft.
    public static int positionInList(List<String> clubs, String name) {
        if (!isUnique(clubs, name)) {
            for (int i = 0; i < clubs.size(); i++) {
                if (name.equalsIgnoreCase(clubs.get(i))) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean isUnique(List<String> clubs, String name) {
        for (String club : clubs) {
            if (club.equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

        // Vraag 3: Maak een methode die de lijst alfabetisch sorteert. Wanneer Ajax niet op positie 1 staat, moeten de
        // clubs die voor Ajax staan verwijderd worden.
        // We voegen nog wat clubs toe om de code te kunnen testen.
    private static void alphabeticalOrderClubsAndAjaxFirst (List<String> clubs){
        Collections.sort(clubs);
        while(positionInList(clubs, "Ajax") != 0) {
            clubs.remove(0);
        }

    }
    private static void alphabeticalOrderClubsAndPSVLast (List<String> clubs) {
        Collections.sort(clubs);
        int positionPSV = positionInList(clubs,"PSV");
        int positionLast = clubs.size();
        while(positionPSV < --positionLast) {
            clubs.remove(positionLast);
        }
    }



        // Vraag 4: Kun je hetzelfde doen als hierboven, maar PSV moet dan laatste zijn.


}
