package ooad.casus.redcars;

import java.util.Random;

class Lidmaatschapspas {
    private long pasnummer;

    Lidmaatschapspas() {
        Random rnd = new Random();
        pasnummer = 100000 + rnd.nextInt(900000);
    }
}
