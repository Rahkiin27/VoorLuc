package ooad.casus.redcars.strategies;

public class StationwagenBetaaldAbonnementStrategy implements IBetalingStrategy {
    public double getPrijsPerKilometer() {
        return 0.3;
    }

    public double getPrijsPerWeek() {
        return 170;
    }

    public double getPrijsPerWeekend() {
        return 80;
    }

    public double getPrijsPerDag() {
        return 50;
    }

    public double getPrijsPerUur() {
        return 5.5;
    }
}
