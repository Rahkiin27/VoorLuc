package ooad.casus.redcars;

import ooad.casus.redcars.enums.PeriodeType;
import ooad.casus.redcars.strategies.IBetalingStrategy;

public class Betaling {
    private IBetalingStrategy betalingStrategy;
    private PeriodeType periodeType;
    private double geredenKilometers;
    private int overschredenUren;

    public Betaling(PeriodeType periodeType, double geredenKilometers, int overschredenUren) {
        this.periodeType = periodeType;
        this.geredenKilometers = geredenKilometers;
        this.overschredenUren = overschredenUren;
    }

    public double berekenTotaalprijs() {
        return berekenKilometerTotaalprijs() + berekenHuurprijs() + berekenBoeteBedrag();
    }

    private double berekenKilometerTotaalprijs() {
        return betalingStrategy.getPrijsPerKilometer() * geredenKilometers;
    }

    private double berekenHuurprijs() {
        switch (periodeType) {
            case UUR:
                return betalingStrategy.getPrijsPerUur();
            case DAG:
                return betalingStrategy.getPrijsPerDag();
            case WEEKEND:
                return betalingStrategy.getPrijsPerWeekend();
            case WEEK:
                return betalingStrategy.getPrijsPerWeek();
        }
        return 0;
    }

    private double berekenBoeteBedrag() {
        if (overschredenUren > 0) {
            return betalingStrategy.getPrijsPerUur() * overschredenUren + berekenHuurprijs();
        }
        return 0;
    }

    public void setBetalingStrategy(IBetalingStrategy betalingStrategy) {
        this.betalingStrategy = betalingStrategy;
    }
}
