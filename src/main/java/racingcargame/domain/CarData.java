package racingcargame.domain;

import java.util.Objects;

public class CarData {

    private final String name;
    private final int position;

    public CarData(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CarData carData = (CarData) o;

        if (position != carData.position) {
            return false;
        }
        return Objects.equals(name, carData.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + position;
        return result;
    }
}
