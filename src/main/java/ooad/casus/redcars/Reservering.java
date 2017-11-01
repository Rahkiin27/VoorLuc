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
    private LocalDateTime beginTijd;
    private LocalDateTime eindTijd;
    private AbonnementType abonnementType;

    public Reservering(PeriodeType periodeType, AutoType autoType, AbonnementType abonnementType, LocalDateTime beginTijd) {
        this.abonnementType = abonnementType;
        this.periodeType = periodeType;
        this.autoType = autoType;
        this.beginTijd = beginTijd;

        eindTijd = berekenEindTijd();

        auto = new Auto("Nijmegen", "FU-CK-ME", 100000);
    }

    public double berekenKosten() {
        Betaling betaling = new Betaling(periodeType, auto.berekenKilometerVerschil(), berekenOverschredenUren());
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
        return betaling.berekenTotaalprijs();
    }

    private int berekenOverschredenUren() {
        return auto.getAantalUrenGebruikt() - ((int) Duration.between(beginTijd, eindTijd).toHours());
    }

    private LocalDateTime berekenEindTijd() {
        LocalDateTime eindTijd = LocalDateTime.from(beginTijd);
        switch (periodeType) {
            case UUR:
                eindTijd = eindTijd.plusHours(1);
                break;
            case DAG:
                eindTijd = eindTijd.plusDays(1);
                break;
            case WEEKEND:
                eindTijd = eindTijd.plusDays(2);
                break;
            case WEEK:
                eindTijd = eindTijd.plusDays(7);
        }
        return eindTijd;
    }
}