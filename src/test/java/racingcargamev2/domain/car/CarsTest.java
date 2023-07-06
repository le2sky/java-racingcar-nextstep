package racingcargamev2.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @DisplayName("자동차는 적어도 하나 이상이어야 한다.")
    @Test
    void carNamesLength() {
        assertThatThrownBy(() -> Cars.from(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차는 적어도 하나 이상이어야 합니다.");
    }

    @DisplayName("모든 자동차의 현재 정보를 가져온다")
    @Test
    void describeAll() {
        Cars cars = Cars.from(List.of("lee", "kim"));

        List<CarDescription> carDescriptions = cars.describeAll();

        assertThat(carDescriptions).isEqualTo(List.of(
                CarDescription.of("lee", 0),
                CarDescription.of("kim", 0)
        ));
    }
}
