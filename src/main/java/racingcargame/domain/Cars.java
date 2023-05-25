package racingcargame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars with(String[] carNames) {
        checkCarNames(carNames);
        return new Cars(Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private static void checkCarNames(String[] carNames) {
        if (Optional.ofNullable(carNames).isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return cars.size();
    }
}
