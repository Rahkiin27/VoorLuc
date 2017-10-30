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

    public double berekenKilometerprijs() {
        return betalingStrategy.getPrijsPerKilometer() * kilometers;
    }

    public double berekenHuurprijs(int periodeDuur) {
        return berekenPeriodePrijs(periodeType, periodeDuur);
    }

    public double berekenBoetebedrag(int periodeDuur, int periodeOverschredenUren) {
        if (periodeOverschredenUren > 0) {
            double huurPrijs = berekenPeriodePrijs(periodeType, periodeDuur);
            double boetebedrag = berekenPeriodePrijs(PeriodeType.UUR, periodeOverschredenUren);
            return huurPrijs + boetebedrag;
        }
        return 0;
    }

    public double berekenPeriodePrijs(PeriodeType periodeType, int periode) {
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
