package racingcargamev2.domain.car;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Cars {

    private static final int MIN_CARS_SIZE = 1;

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        checkCarsSize(cars);

        this.cars = cars;
    }

    public static Cars from(final List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::from)
                .collect(toList()));
    }

    private void checkCarsSize(final List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException("자동차는 적어도 하나 이상이어야 합니다.");
        }
    }

    public List<CarDescription> describeAll() {
        return cars.stream()
                .map(Car::describeSelf)
                .collect(toList());
    }
}
