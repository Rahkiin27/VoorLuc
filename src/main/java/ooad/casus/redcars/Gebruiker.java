package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;

import java.time.LocalDateTime;

public class Gebruiker {
    private String voornaam, achternaam, email, adres, woonplaats, bankrekeningnummer;
    private AbonnementType abonnementType;
    private Lidmaatschapspas lidmaatschapspas;
    private boolean isActief;
    private Reservering reservering;

    public Gebruiker(String voornaam, String achternaam, String email, String adres, String woonplaats, String bankrekeningnummer, AbonnementType abonnementType) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.adres = adres;
        this.woonplaats = woonplaats;
        this.abonnementType = abonnementType;
        this.bankrekeningnummer = bankrekeningnummer;

        isActief = true;

        lidmaatschapspas = new Lidmaatschapspas();
    }

    public void maakReservering(PeriodeType periodeType, int periodeAantal, AutoType autoType, LocalDateTime beginTijd) {
        if (isActief) {
            reservering = new Reservering(periodeType, periodeAantal, autoType, abonnementType, beginTijd);
        }
    }

    public double berekenKosten() {
        if (reservering != null) {
            return reservering.berekenKosten();
        }
        return 0;
    }

    public void setAbonnementType(AbonnementType abonnementType) {
        this.abonnementType = abonnementType;
    }

    public void setActief(boolean actief) {
        isActief = actief;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public void setBankrekeningnummer(String bankrekeningnummer) {
        this.bankrekeningnummer = bankrekeningnummer;
    }
}