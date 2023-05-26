package racingcargame.domain;

import java.util.List;
import java.util.Objects;

public class PlayResult {

    private final List<CarData> carsDataList;

    public PlayResult(List<CarData> carsDataList) {
        this.carsDataList = carsDataList;
    }

    public List<CarData> getCarsDataList() {
        return carsDataList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayResult that = (PlayResult) o;

        return Objects.equals(carsDataList, that.carsDataList);
    }

    @Override
    public int hashCode() {
        return carsDataList != null ? carsDataList.hashCode() : 0;
    }
}
