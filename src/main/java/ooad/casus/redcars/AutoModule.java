package ooad.casus.redcars;

public class AutoModule {
    private double kilometersGereden;
    private int urenGebruikt;

    public int getUrenGebruikt() {
        return urenGebruikt;
    }

    public double getKilometersGereden() {
        return kilometersGereden;
    }

    public void initialiseerModule() {
        kilometersGereden = Math.random() * 100;
        kilometersGereden = Math.round((kilometersGereden * 100)) / (double)100;
        urenGebruikt = (int)(Math.random() * 10 + 1);
        System.out.println("Kilomterstand: " + kilometersGereden + " | Uren gebruikt: " + urenGebruikt);
    }

    public void stopModule() {
        kilometersGereden = 0;
        urenGebruikt = 0;
    }
}
