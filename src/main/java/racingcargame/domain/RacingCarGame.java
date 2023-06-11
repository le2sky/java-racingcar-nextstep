package racingcargame.domain;

import java.util.Optional;

public class RacingCarGame {

    public static final int MINIMUM_PARTICIPANT_COUNT = 1;
    public static final int MINIMUM_ROUND_COUNT = 1;
    private final RandomGenerator randomGenerator;
    private final Cars cars;
    private int roundCount;

    public RacingCarGame(int roundCount, String[] carNames, RandomGenerator randomGenerator) {
        checkRoundCountRange(roundCount);
        checkCarNames(carNames);
        checkRandomGenerator(randomGenerator);

        this.roundCount = roundCount;
        this.cars = Cars.with(carNames);
        this.randomGenerator = randomGenerator;
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

    private void checkRandomGenerator(RandomGenerator randomGenerator) {
        if (Optional.ofNullable(randomGenerator).isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public PlayResult play() {
        checkRoundCountRange(roundCount--);
        return cars.playRound(randomGenerator
                .generateWithSize(cars.size()));
    }

    public int getRoundCount() {
        return roundCount;
    }

    public int getParticipantCarCount() {
        return cars.size();
    }
}