package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;
import ooad.casus.redcars.strategies.*;

public class Betaling {
    private IBetalingStrategy betalingStrategy;
    private BetalingBerekeningen berekening;

    public Betaling(AbonnementType abonnementType, PeriodeType periodeType, AutoType autoType, double kilometers) {
        switch(abonnementType) {
            case BETAALD:
                switch (autoType) {
                    case PERSONEN:
                        betalingStrategy = new PersonenautoBetaaldAbonnementStrategy();
                        break;
                    case STATION:
                        betalingStrategy = new StationwagenBetaaldAbonnementStrategy();
                        break;
                }
                break;
            case GRATIS:
                switch (autoType) {
                    case PERSONEN:
                        betalingStrategy = new PersonenautoGratisAbonnementStrategy();
                        break;
                    case STATION:
                        betalingStrategy = new StationwagenGratisAbonnementStrategy();
                        break;
                }
                break;
        }
        berekening = new BetalingBerekeningen(betalingStrategy, periodeType, kilometers);
    }

    public double berekenTotaalprijs(int periodeDuur, int urenGereden) {
        return berekening.berekenTotaalprijs(periodeDuur, urenGereden);
    }
}
