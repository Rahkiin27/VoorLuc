package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;

public class Reservering {
    private Auto auto;
    private AutoType autoType;
    private PeriodeType periodeType;
    private int periodeDuur;

    public Reservering(PeriodeType periodeType, int periodeDuur, AutoType autoType) {
        auto = new Auto("Nijmegen", "FU-CK-ME", 100000, autoType);
        auto.setAantalUrenGereden(5);
        auto.updateKilometerstand(50);
        this.periodeType = periodeType;
        this.periodeDuur = periodeDuur;
        this.autoType = autoType;
    }

    public double berekenKosten(AbonnementType abonnementType) {
        Betaling betaling = new Betaling(abonnementType, periodeType, autoType, auto.berekenKilometerVerschil());
        return betaling.berekenTotaalprijs(periodeDuur, auto.getAantalUrenGereden());
    }
}