package ooad.casus.redcars;

public class Auto {
    private long pasnummer;
    private AutoModule autoModule;
    private String standplaats, kenteken, lidmaatschapspasnummer;

    public Auto(String standplaats, String kenteken, long pasnummer) {
        this.standplaats = standplaats;
        this.kenteken = kenteken;
        this.pasnummer = pasnummer;

        autoModule = new AutoModule();
    }

    public double getKilometersGereden() {
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

    public void meldAan(long pasnummer) {
        if (this.pasnummer == pasnummer) {
            autoModule.initialiseerModule();
        }
    }

    public void meldAf(long pasnummer) {
        if(this.pasnummer == pasnummer) {
            autoModule.stopModule();
        }
    }
}