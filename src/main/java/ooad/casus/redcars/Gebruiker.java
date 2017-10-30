package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;

import java.time.LocalDateTime;

public class Gebruiker {
    private String voornaam, achternaam, email, adres, woonplaats, bankrekeningnummer;
    private AbonnementType abonnementType;
    private Lidmaatschapspas lidmaatschapspas;

    public Gebruiker(String voornaam, String achternaam, String email, String adres, String woonplaats, String bankrekeningnummer, AbonnementType abonnementType) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.adres = adres;
        this.woonplaats = woonplaats;
        this.abonnementType = abonnementType;
        this.bankrekeningnummer = bankrekeningnummer;

        lidmaatschapspas = new Lidmaatschapspas();
    }

    public void maakReservering() {
        Reservering reservering = new Reservering(PeriodeType.DAG, AutoType.STATION, LocalDateTime.now());
    }
}
