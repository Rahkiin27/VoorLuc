package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;

import java.time.LocalDateTime;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        App main = new App();
        main.testBetaling();
    }

    private void testBetaling() {
        AutoType autoType = AutoType.STATION;

        LocalDateTime beginTijd = LocalDateTime.of(2000, 12, 1, 1, 0, 0, 0);

        Reservering reservering = new Reservering(PeriodeType.WEEKEND, autoType, beginTijd);
        System.out.println(reservering.berekenKosten(AbonnementType.BETAALD));
    }
}