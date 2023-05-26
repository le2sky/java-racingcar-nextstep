package racingcargame.domain;

import java.util.Optional;

public class RacingCarGame {

    public static final int MINIMUM_PARTICIPANT_COUNT = 1;
    public static final int MINIMUM_ROUND_COUNT = 1;
    private final Cars cars;
    private int roundCount;

    public RacingCarGame(int roundCount, String[] carNames) {
        checkRoundCountRange(roundCount);
        checkCarNames(carNames);
        this.roundCount = roundCount;
        this.cars = Cars.with(carNames);
    }

    public void play() {
        checkRoundCountRange(roundCount--);
    }

    private void checkRoundCountRange(int roundCount) {
        if (roundCount < MINIMUM_ROUND_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCarNames(String[] carNames) {
        if (isInvalidCarNames(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidCarNames(String[] carNames) {
        return Optional.ofNullable(carNames).isEmpty()
                || carNames.length < MINIMUM_PARTICIPANT_COUNT;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public int getParticipantCarCount() {
        return cars.size();
    }
}