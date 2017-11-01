package ooad.casus.redcars;

public class AutoModule {
    private double kilometersGereden;
    private int urenGebruikt;

    public AutoModule() {
      kilometersGereden = Math.random() * 50;
      urenGebruikt = (int)(Math.random() * 10);
      System.out.println("Kilomterstand: " + kilometersGereden + " | Uren gebruikt: " + urenGebruikt);
    }

    public int getUrenGebruikt() {
        return urenGebruikt;
    }

    public double getKilometersGereden() {
        return kilometersGereden;
    }
}
