package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;
import ooad.casus.redcars.strategies.*;

public class Betaling {
    private IBetalingStrategy betalingStrategy;
    private BetalingBerekeningen berekening;
    private PeriodeType periodeType;

    public Betaling(AbonnementType abonnementType, PeriodeType periodeType, AutoType autoType, double kilometers) {
        this.periodeType = periodeType;
        switch(abonnementType) {
            case BETAALD:
                if (autoType == AutoType.PERSONEN) {
                    betalingStrategy = new PersonenautoBetaaldAbonnementStrategy();
                }
                else if (autoType == AutoType.STATION) {
                    betalingStrategy = new StationwagenBetaaldAbonnementStrategy();
                }
                break;
            case GRATIS:
                if (autoType == AutoType.PERSONEN) {
                    betalingStrategy = new PersonenautoGratisAbonnementStrategy();
                }
                else if (autoType == AutoType.STATION) {
                    betalingStrategy= new StationwagenGratisAbonnementStrategy();
                }
                break;
        }
        berekening = new BetalingBerekeningen(betalingStrategy, kilometers);
    }

    public double berekenTotaalprijs(int periodeDuur, int urenGereden) {
        int periodeOverschredenUren = 0;
        switch (periodeType) {
            case UUR:
                if (urenGereden > periodeDuur) {
                    periodeOverschredenUren = urenGereden - periodeDuur;
                }
                break;
            case DAG:
                if (urenGereden > periodeDuur * 24) {
                    periodeOverschredenUren = urenGereden - periodeDuur * 24;
                }
                break;
            case WEEKEND:
                if (urenGereden > periodeDuur * 48) {
                    periodeOverschredenUren = urenGereden - periodeDuur * 48;
                }
                break;
            case WEEK:
                if (urenGereden > periodeDuur * 168) {
                    periodeOverschredenUren = urenGereden - periodeDuur * 168;
                }
                break;
        }
        return berekening.berekenTotaalprijs(berekenPeriodePrijs(periodeType, periodeDuur), berekenPeriodePrijs(PeriodeType.UUR, periodeOverschredenUren));
    }

    private double berekenPeriodePrijs(PeriodeType periodeType, int periode) {
        switch (periodeType) {
            case UUR:
                return betalingStrategy.getPrijsPerUur() * periode;
            case DAG:
                return betalingStrategy.getPrijsPerDag() * periode;
            case WEEKEND:
                return betalingStrategy.getPrijsPerWeekend() * periode;
            case WEEK:
                return betalingStrategy.getPrijsPerWeek() * periode;
        }
        return 0;
    }
}
