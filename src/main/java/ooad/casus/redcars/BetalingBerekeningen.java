package ooad.casus.redcars;

import ooad.casus.redcars.strategies.IBetalingStrategy;

public class BetalingBerekeningen {
    private IBetalingStrategy betalingStrategy;
    private double kilometers;

    public BetalingBerekeningen(IBetalingStrategy betalingStrategy, double kilometers) {
        this.betalingStrategy = betalingStrategy;
        this.kilometers = kilometers;
    }

    public double berekenTotaalprijs(double periodebedrag, double boetebedrag) {
        boetebedrag = berekenBoetebedrag(boetebedrag, periodebedrag);
        System.out.println("km: " + berekenKilometerprijs() + " | huur: " + periodebedrag + " | boete:" + boetebedrag);
        return berekenKilometerprijs() + periodebedrag + boetebedrag;
    }

    private double berekenKilometerprijs() {
        return betalingStrategy.getPrijsPerKilometer() * kilometers;
    }

    private double berekenBoetebedrag(double boetebedrag, double periodebedrag) {
        if (boetebedrag > 0) {
            return boetebedrag + periodebedrag;
        }
        return 0;
    }
}