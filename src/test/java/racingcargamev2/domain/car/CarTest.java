package racingcargamev2.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차의 전진 조건은 4이상의 숫자이다.")
    @Test
    void move() {
        Car car = Car.of("lee");

        car.move(4);
        car.move(3);

        assertThat(car.describeSelf())
                .isEqualTo(CarDescription.of("lee", 1));
    }

    @DisplayName("전진에 필요한 숫자는 0에서 9사이의 숫자이다.")
    @Test
    void moveNumberRange() {
        Car car = Car.of("lee");

        assertThatThrownBy(() -> car.move(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("전진에 필요한 숫자는 0에서 9사이의 숫자입니다.");

        assertThatThrownBy(() -> car.move(10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("전진에 필요한 숫자는 0에서 9사이의 숫자입니다.");
    }

    @DisplayName("자동차의 현재 정보를 가져올 수 있다.")
    @Test
    void describeSelf() {
        Car car = Car.of("lee");

        car.move(5);

        assertThat(car.describeSelf())
                .isEqualTo(CarDescription.of("lee", 1));
    }
}
