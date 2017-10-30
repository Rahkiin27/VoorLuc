package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;

public class App {
    public static void main(String[] args) {
        App main = new App();
        main.testBetaling();
    }

    private void testBetaling() {
        AutoType autoType = AutoType.STATION;
        Reservering reservering = new Reservering(PeriodeType.UUR, 4, autoType);
        System.out.println(reservering.berekenKosten(AbonnementType.BETAALD));
    }
}