package ooad.casus.redcars;

import java.util.Random;

public class Lidmaatschapspas {
    private long pasnummer;

    public Lidmaatschapspas() {
        Random rnd = new Random();
        pasnummer = 100000 + rnd.nextInt(900000);
    }
}
