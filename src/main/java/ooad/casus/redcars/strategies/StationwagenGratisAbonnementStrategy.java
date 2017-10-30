package ooad.casus.redcars.strategies;

public class StationwagenGratisAbonnementStrategy implements IBetalingStrategy  {
    public double getPrijsPerKilometer() {
        return 0.35;
    }

    public double getPrijsPerWeek() {
        return 180;
    }

    public double getPrijsPerWeekend() {
        return 90;
    }

    public double getPrijsPerDag() {
        return 60;
    }

    public double getPrijsPerUur() {
        return 7.5;
    }
}
