package racingcargame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcargame.CarTest.Car;

public class CarsTest {

    @Test
    void 자동차를_생성한다() {
        Cars cars = Cars.with(new String[]{"a", "b", "c"});
        assertThat(cars.size()).isEqualTo(3);

        Cars cars2 = Cars.with(new String[]{"a", "b", "c", "d"});
        assertThat(cars2.size()).isEqualTo(4);
    }

    @Test
    void null이나_빈문자열_혹은_블랭크가_들어오면_예외를_발생한다() {
        assertThatThrownBy(() -> {
            Cars.with(new String[]{"", "A"});
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Cars.with(new String[]{"B", null});
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Cars.with(new String[]{"  ", "C"});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    public static class Cars {

        private final List<Car> cars;

        private Cars(List<Car> cars) {
            this.cars = cars;
        }

        public static Cars with(String[] carNames) {
            checkInput(carNames);
            return new Cars(Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList()));
        }

        private static void checkInput(String[] carNames) {
            if (Optional.ofNullable(carNames).isEmpty()) {
                throw new IllegalArgumentException();
            }
        }

        public int size() {
            return cars.size();
        }
    }
}
