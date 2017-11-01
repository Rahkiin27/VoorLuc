package ooad.casus.redcars;

import ooad.casus.redcars.enums.AbonnementType;
import ooad.casus.redcars.enums.AutoType;
import ooad.casus.redcars.enums.PeriodeType;
import ooad.casus.redcars.strategies.PersonenautoBetaaldAbonnementStrategy;
import ooad.casus.redcars.strategies.PersonenautoGratisAbonnementStrategy;
import ooad.casus.redcars.strategies.StationwagenBetaaldAbonnementStrategy;
import ooad.casus.redcars.strategies.StationwagenGratisAbonnementStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class Reservering {
    private Auto auto;
    private AutoType autoType;
    private PeriodeType periodeType;
    private int periodeAantal;
    private LocalDateTime beginTijd;
    private LocalDateTime eindTijd;
    private AbonnementType abonnementType;

    public Reservering(PeriodeType periodeType, int periodeAantal, AutoType autoType, AbonnementType abonnementType, LocalDateTime beginTijd, long pasnummer) {
        this.abonnementType = abonnementType;
        this.periodeType = periodeType;
        this.autoType = autoType;
        this.beginTijd = beginTijd;
        this.periodeAantal = periodeAantal;

        eindTijd = berekenEindTijd();
        System.out.println("Periode gereserveerd: " + periodeAantal + " " + periodeType);

        auto = new Auto("Nijmegen", "FU-CK-ME", pasnummer);
    }

    public double berekenKosten() {
        Betaling betaling = new Betaling(periodeType, auto.getKilometersGereden(), berekenOverschredenUren());
        switch (abonnementType) {
            case BETAALD:
                switch (autoType) {
                    case PERSONEN:
                        betaling.setBetalingStrategy(new PersonenautoBetaaldAbonnementStrategy());
                        break;
                    case STATION:
                        betaling.setBetalingStrategy(new StationwagenBetaaldAbonnementStrategy());
                        break;
                }
                break;
            case GRATIS:
                switch (autoType) {
                    case PERSONEN:
                        betaling.setBetalingStrategy(new PersonenautoGratisAbonnementStrategy());
                        break;
                    case STATION:
                        betaling.setBetalingStrategy(new StationwagenGratisAbonnementStrategy());
                        break;
                }
                break;
        }
        return betaling.berekenTotaalprijs(periodeAantal);
    }

    private int berekenOverschredenUren() {
        return auto.getAantalUrenGebruikt() - ((int) Duration.between(beginTijd, eindTijd).toHours());
    }

    private LocalDateTime berekenEindTijd() {
        LocalDateTime eindTijd = LocalDateTime.from(beginTijd);
        switch (periodeType) {
            case UUR:
                eindTijd = eindTijd.plusHours(1 * periodeAantal);
                break;
            case DAG:
                eindTijd = eindTijd.plusDays(1 * periodeAantal);
                break;
            case WEEKEND:
                eindTijd = eindTijd.plusDays(2 * periodeAantal);
                break;
            case WEEK:
                eindTijd = eindTijd.plusDays(7 * periodeAantal);
        }
        return eindTijd;
    }

    public Auto getAuto() {
        return auto;
    }
}