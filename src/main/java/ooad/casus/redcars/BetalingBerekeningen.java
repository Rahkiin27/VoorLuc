package ooad.casus.redcars;

import ooad.casus.redcars.enums.PeriodeType;
import ooad.casus.redcars.strategies.IBetalingStrategy;

public class BetalingBerekeningen {
    private IBetalingStrategy betalingStrategy;
    private PeriodeType periodeType;
    private double kilometers;

    public BetalingBerekeningen(IBetalingStrategy betalingStrategy, PeriodeType periodeType, double kilometers) {
        this.betalingStrategy = betalingStrategy;
        this.periodeType = periodeType;
        this.kilometers = kilometers;
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
        System.out.println("km: " + berekenKilometerprijs() + " | huur: " + berekenHuurprijs(periodeDuur) + " | boete:" + berekenBoetebedrag(periodeDuur, periodeOverschredenUren));
        return berekenKilometerprijs() + berekenHuurprijs(periodeDuur) + berekenBoetebedrag(periodeDuur, periodeOverschredenUren);
    }

    private double berekenKilometerprijs() {
        return betalingStrategy.getPrijsPerKilometer() * kilometers;
    }

    private double berekenHuurprijs(int periodeDuur) {
        return berekenPeriodePrijs(periodeType, periodeDuur);
    }

    private double berekenBoetebedrag(int periodeDuur, int periodeOverschredenUren) {
        if (periodeOverschredenUren > 0) {
            double huurPrijs = berekenPeriodePrijs(periodeType, periodeDuur);
            double boetebedrag = berekenPeriodePrijs(PeriodeType.UUR, periodeOverschredenUren);
            return huurPrijs + boetebedrag;
        }
        return 0;
    }

    private double berekenPeriodePrijs(PeriodeType periodeType, int periode) {
        switch(periodeType) {
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
