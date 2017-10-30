package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;
import ooad.casus.redcars.strategies.*;

public class Betaling {
    private IBetalingStrategy betalingStrategy;
    private PeriodeType periodeType;
    BetalingBerekeningen berekening;

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
        berekening = new BetalingBerekeningen(betalingStrategy, periodeType, kilometers);
    }

    public double berekenTotaalprijs(int periodeDuur, int urenGereden) {
        int periodeOverschredenUren = 0;
        switch(periodeType) {
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
        System.out.println("km: " + berekening.berekenKilometerprijs() + " | huur: " + berekening.berekenHuurprijs(periodeDuur) + " | boete:" + berekening.berekenBoetebedrag(periodeDuur, periodeOverschredenUren));
        return berekening.berekenKilometerprijs() + berekening.berekenHuurprijs(periodeDuur) + berekening.berekenBoetebedrag(periodeDuur, periodeOverschredenUren);
    }
}
