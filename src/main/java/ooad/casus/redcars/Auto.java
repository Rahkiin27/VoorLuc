package ooad.casus.redcars;

import ooad.casus.redcars.enums.AutoType;

class Auto {
    private String standplaats, kenteken;
    private double kilometerstand, vorigeKilometerstand;
    private AutoType autoType;
    private int urenGereden;

    Auto(String standplaats, String kenteken, double kilometerstand, AutoType autoType) {
        this.autoType = autoType;
        this.standplaats = standplaats;
        this.kenteken = kenteken;
        this.kilometerstand = kilometerstand;
        resetAuto();
    }

    double berekenKilometerVerschil() {
        return (kilometerstand - vorigeKilometerstand);
    }

    void updateKilometerstand(double geredenKilometers) {
        kilometerstand = kilometerstand + geredenKilometers;
    }

    void resetAuto() {
        vorigeKilometerstand = kilometerstand;
        urenGereden = 0;
    }

    AutoType getAutoType() {
        return autoType;
    }

    int getAantalUrenGereden() {
        return urenGereden;
    }

    void setAantalUrenGereden(int uren) {
        this.urenGereden = uren;
    }
}
