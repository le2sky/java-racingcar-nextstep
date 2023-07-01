package racingcargamev2.domain;

public class RacingGame {

    private final Round round;

    private RacingGame(final int round) {
        this.round = Round.of(round);
    }

    public static RacingGame of(final int round) {
        return new RacingGame(round);
    }
}
