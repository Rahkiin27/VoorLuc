package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;

import java.time.LocalDateTime;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        App main = new App();
        main.testBetaling();
    }

    private void testBetaling() {
        Gebruiker gebruiker = new Gebruiker("Voornaam", "Achternaam", "email.emailadres@emailadres.email", "Tolhuis7319",
                                                        "Nijmegen", "NL83INGB142987", AbonnementType.BETAALD);

        gebruiker.maakReservering();
        System.out.println("Kosten van de reservering: " + gebruiker.berekenKosten());
    }
}