package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;

import java.time.LocalDateTime;

public class Gebruiker {
    private String voornaam, achternaam, email, adres, woonplaats, bankrekeningnummer;
    private AbonnementType abonnementType;
    private Lidmaatschapspas lidmaatschapspas;
    private Reservering reservering;

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

    public void maakReservering(PeriodeType periodeType, AutoType autoType, LocalDateTime beginTijd) {
        reservering = new Reservering(periodeType, autoType, abonnementType, beginTijd);
    }

    public double berekenKosten() {
        return reservering.berekenKosten();
    }

    public void setAbonnementType(AbonnementType abonnementType) {
        this.abonnementType = abonnementType;
    }
}
