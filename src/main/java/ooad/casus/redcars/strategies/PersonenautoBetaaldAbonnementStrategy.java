package ooad.casus.redcars.strategies;

public class PersonenautoBetaaldAbonnementStrategy implements IBetalingStrategy {
    public double getPrijsPerKilometer() {
        return 0.25;
    }

    public double getPrijsPerWeek() {
        return 140;
    }

    public double getPrijsPerWeekend() {
        return 60;
    }

    public double getPrijsPerDag() {
        return 40;
    }

    public double getPrijsPerUur() {
        return 4;
    }
}
