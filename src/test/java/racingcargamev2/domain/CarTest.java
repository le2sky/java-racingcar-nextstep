package racingcargamev2.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void carNameLength() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차 이름은 빈문자열이 될 수 없다.")
    @Test
    void carNameIsNotEmptyString() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 빈 문자열이 될 수 없습니다.");
    }

    @DisplayName("자동차 이름에 널값을 허용하지 않는다.")
    @Test
    void carNameIsNotAllowNull() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름에 널값을 허용하지 않습니다.");
    }
}
