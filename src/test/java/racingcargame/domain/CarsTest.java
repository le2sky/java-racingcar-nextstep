package racingcargame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarsTest {

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

    @Test
    void 자동차_이름_배열이_null인_경우_예외를_발생한다() {
        assertThatThrownBy(() -> {
            Cars.with(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
