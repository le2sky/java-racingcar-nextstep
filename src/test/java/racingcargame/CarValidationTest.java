package racingcargame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class CarValidationTest {

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
    void 자동차_이름이_5자_이하인_경우_예외를_발생하지_않는다() {
        checkCarName("abcde");
        checkCarName("a");
    }

    private void assertThrowingException(String carName) {
        assertThatThrownBy(() -> {
            checkCarName(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    private void checkCarName(String carName) {
        checkNullOrEmpty(carName);
        checkCarNameLength(carName);
    }

    private static void checkNullOrEmpty(String carName) {
        if (Optional.ofNullable(carName).isEmpty() || carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
