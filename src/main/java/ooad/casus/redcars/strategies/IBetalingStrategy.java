package ooad.casus.redcars.strategies;

/**
 * Created by Dustin on 10/29/2017.
 */
public interface IBetalingStrategy {
    double getPrijsPerKilometer();
    double getPrijsPerWeek();
    double getPrijsPerWeekend();
    double getPrijsPerDag();
    double getPrijsPerUur();
}
