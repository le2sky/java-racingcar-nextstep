package racingcargame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름이_5자_초과인_경우_예외를_발생한다() {
        assertThrowingException("abcdef");
    }

    @Test
    void 자동차_이름이_null이거나_빈_문자열인_경우_예외를_발생한다() {
        assertThrowingException(null);
        assertThrowingException("");
    }

    @Test
    public void 자동차_이름이_블랭크인_경우_예외를_발생한다() {
        assertThrowingException("\n");
        assertThrowingException("  ");
        assertThrowingException(" ");
    }

    @Test
    void 자동차_이름이_5자_이하인_경우_예외를_발생하지_않는다() {
        checkCarName("abcde");
        checkCarName("a");
    }

    @Test
    void 자동차에_랜덤값이_4이상일_경우_전진이_가능하다() {
        Car car = new Car("test");
        car.move(4);
        car.move(9);
        car.move(3);
        car.move(0);

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 자동차에_들어올_수_있는_숫자가_0부터_9사이의_숫자가_아니면_예외를_발생한다() {
        Car car = new Car("test");
        assertThatThrownBy(() -> {
            car.move(-1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            car.move(10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private void assertThrowingException(String carName) {
        assertThatThrownBy(() -> {
            checkCarName(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private void checkCarName(String carName) {
        new Car(carName);
    }

    public static class Car {

        private static final int MAXIMUM_NAME_LENGTH = 5;
        public static final int MINIMUM_NUMBER_FOR_MOVE_EXECUTE = 0;
        public static final int MAXIMUM_NUMBER_FOR_MOVE_EXECUTE = 9;
        public static final int MOVABLE_STANDARD = 4;
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
}
