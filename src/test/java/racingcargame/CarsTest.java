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
    void 콤마를_구분자로_이용해서_자동차를_생성한다() {
        Cars cars = createCars("a,b,c");
        assertThat(cars.size()).isEqualTo(3);

        Cars cars2 = createCars("a,b,c,d");
        assertThat(cars2.size()).isEqualTo(4);
    }

    @Test
    void null이나_빈문자열_혹은_블랭크가_들어오면_예외를_발생한다() {
        assertThatThrownBy(() -> {
            createCars("");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            createCars(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            createCars("  ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private Cars createCars(String input) {
        return Cars.with(input);
    }

    public static class Cars {

        private final List<Car> cars;

        private Cars(List<Car> cars) {
            this.cars = cars;
        }

        public static Cars with(String input) {
            checkInput(input);
            return new Cars(Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));
        }

        private static void checkInput(String input) {
            if (Optional.ofNullable(input).isEmpty()) {
                throw new IllegalArgumentException();
            }
        }

        public int size() {
            return cars.size();
        }
    }
}
