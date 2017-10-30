package ooad.casus.redcars.strategies;


public class PersonenautoGratisAbonnementStrategy implements IBetalingStrategy {
    public double getPrijsPerKilometer() {
        return 0.3;
    }

    public double getPrijsPerWeek() {
        return 150;
    }

    public double getPrijsPerWeekend() {
        return 70;
    }

    public double getPrijsPerDag() {
        return 50;
    }

    public double getPrijsPerUur() {
        return 6;
    }
}
