package racingcargamev2.domain.game;

import java.util.List;
import racingcargamev2.domain.car.Cars;

public class RacingGame {

    private final Round round;
    private final Cars cars;

    private RacingGame(final int round, final List<String> carNames) {
        this.round = Round.from(round);
        this.cars = Cars.from(carNames);
    }

    public static RacingGame of(final int round, final List<String> carNames) {
        return new RacingGame(round, carNames);
    }

    public void race() {
        round.race();
    }

    public boolean isEnd() {
        return round.isEnd();
    }

    public RoundSummary generateRoundSummary() {
        return RoundSummary.from(cars.describeAll());
    }
}
