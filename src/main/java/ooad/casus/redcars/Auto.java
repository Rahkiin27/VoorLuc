package ooad.casus.redcars;

import ooad.casus.redcars.enums.AutoType;

public class Auto {
    private String standplaats, kenteken;
    private double kilometerstand, vorigeKilometerstand;
    private int urenGereden;

    public Auto(String standplaats, String kenteken, double kilometerstand) {
        this.standplaats = standplaats;
        this.kenteken = kenteken;
        this.kilometerstand = kilometerstand;

        vorigeKilometerstand = kilometerstand;
    }

    public double berekenKilometerVerschil() {
        return (kilometerstand - vorigeKilometerstand);
    }

    public void updateKilometerstand(double geredenKilometers) {
        kilometerstand = kilometerstand + geredenKilometers;
    }

    public int getAantalUrenGereden() {
        return urenGereden;
    }

    public void setAantalUrenGereden(int uren) {
        this.urenGereden = uren;
    }
}