package ooad.casus.redcars;

public class Auto {
    private AutoModule autoModule;
    private String standplaats, kenteken;

    public Auto(String standplaats, String kenteken, double kilometerstand) {
        this.standplaats = standplaats;
        this.kenteken = kenteken;

        autoModule = new AutoModule();
    }

    public double berekenKilometerVerschil() {
        return autoModule.getKilometersGereden();
    }

    public int getAantalUrenGebruikt() {
        return autoModule.getUrenGebruikt();
    }

    public void setStandplaats(String standplaats) {
        this.standplaats = standplaats;
    }

    public void setKenteken(String kenteken) {
        this.kenteken = kenteken;
    }
}