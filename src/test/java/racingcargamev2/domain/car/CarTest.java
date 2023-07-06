package racingcargamev2.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargamev2.domain.car.policy.AlwayMovePolicy;
import racingcargamev2.domain.car.policy.NeverMovePolicy;

public class CarTest {

    @DisplayName("정책이 성공하면 자동차를 움직일 수 있다.")
    @Test
    void move() {
        Car car = Car.of("lee", new AlwayMovePolicy());

        car.move();
        car.move();

        assertThat(car.describeSelf())
                .isEqualTo(CarDescription.of("lee", 2));
    }

    @DisplayName("정책이 실패하면 자동차를 움직일 수 없다.")
    @Test
    void noMove() {
        Car car = Car.of("lee", new NeverMovePolicy());

        car.move();
        car.move();

        assertThat(car.describeSelf())
                .isEqualTo(CarDescription.of("lee", 0));
    }

    @DisplayName("자동차의 현재 정보를 가져올 수 있다.")
    @Test
    void describeSelf() {
        Car car = Car.of("lee", new AlwayMovePolicy());

        car.move();

        assertThat(car.describeSelf())
                .isEqualTo(CarDescription.of("lee", 1));
    }
}
