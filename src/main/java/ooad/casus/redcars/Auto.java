package ooad.casus.redcars;

public class Auto {
    private String standplaats, kenteken;
    private double kilometerstand, vorigeKilometerstand;
    private int urenGebruikt;

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

    public int getAantalUrenGebruikt() {
        return urenGebruikt;
    }

    public void setAantalUrenGebruikt(int uren) {
        this.urenGebruikt = uren;
    }
}