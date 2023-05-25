package racingcargame.domain;
import java.util.Optional;

public class Car {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NUMBER_FOR_MOVE_EXECUTE = 0;
    private static final int MAXIMUM_NUMBER_FOR_MOVE_EXECUTE = 9;
    private static final int MOVABLE_STANDARD = 4;
    private int position;

    public Car(String carName) {
        checkInvalidFormat(carName);
        checkCarNameLength(carName);
        this.position = 0;
    }

    private void checkInvalidFormat(String carName) {
        if (isNullOrEmpty(carName) || carName.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNullOrEmpty(String carName) {
        return Optional.ofNullable(carName).isEmpty() || carName.isEmpty();
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int num) {
        checkNumberRange(num);
        if (num < MOVABLE_STANDARD) {
            return;
        }
        position++;
    }

    private void checkNumberRange(int num) {
        if (num < MINIMUM_NUMBER_FOR_MOVE_EXECUTE || num > MAXIMUM_NUMBER_FOR_MOVE_EXECUTE) {
            throw new IllegalArgumentException();
        }
    }

    public int getPosition() {
        return position;
    }
}
