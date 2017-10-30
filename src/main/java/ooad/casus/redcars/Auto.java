package ooad.casus.redcars;

import ooad.casus.redcars.enums.AutoType;

public class Auto {
    private String standplaats, kenteken;
    private double kilometerstand, vorigeKilometerstand;
    private AutoType autoType;
    private int urenGereden;

    public Auto(String standplaats, String kenteken, double kilometerstand, AutoType autoType) {
        this.autoType = autoType;
        this.standplaats = standplaats;
        this.kenteken = kenteken;
        this.kilometerstand = kilometerstand;
        resetAuto();
    }

    public double berekenKilometerVerschil() {
        return (kilometerstand - vorigeKilometerstand);
    }

    public void updateKilometerstand(double geredenKilometers) {
        kilometerstand = kilometerstand + geredenKilometers;
    }

    public void resetAuto() {
        vorigeKilometerstand = kilometerstand;
        urenGereden = 0;
    }

    public AutoType getAutoType() {
        return autoType;
    }

    public int getAantalUrenGereden() {
        return urenGereden;
    }

    public void setAantalUrenGereden(int uren) {
        this.urenGereden = uren;
    }
}
