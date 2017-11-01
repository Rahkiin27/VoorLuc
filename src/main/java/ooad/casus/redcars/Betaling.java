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

    public double berekenTotaalprijs(int periodeAantal) {
        System.out.println("Kilomterprijs: " + berekenKilometerTotaalprijs() + " | Huurprijs: " + berekenHuurprijs(periodeAantal) + " | Boete: " + berekenBoeteBedrag(periodeAantal));
        return berekenKilometerTotaalprijs() + berekenHuurprijs(periodeAantal) + berekenBoeteBedrag(periodeAantal);
    }

    private double berekenKilometerTotaalprijs() {
        return betalingStrategy.getPrijsPerKilometer() * geredenKilometers;
    }

    private double berekenHuurprijs(int periodeAantal) {
        switch (periodeType) {
            case UUR:
                return betalingStrategy.getPrijsPerUur() * periodeAantal;
            case DAG:
                return betalingStrategy.getPrijsPerDag() * periodeAantal;
            case WEEKEND:
                return betalingStrategy.getPrijsPerWeekend() * periodeAantal;
            case WEEK:
                return betalingStrategy.getPrijsPerWeek() * periodeAantal;
        }
        return 0;
    }

    private double berekenBoeteBedrag(int periodeAantal) {
        if (overschredenUren > 0) {
            return betalingStrategy.getPrijsPerUur() * overschredenUren + berekenHuurprijs(periodeAantal);
        }
        return 0;
    }

    public void setBetalingStrategy(IBetalingStrategy betalingStrategy) {
        this.betalingStrategy = betalingStrategy;
    }
}
