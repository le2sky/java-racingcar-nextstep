package racingcargamev2.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @DisplayName("포지션은 음수일 수 없다.")
    @Test
    void negativePosition() {
        assertThatThrownBy(() -> Position.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 음수일 수 없습니다.");
    }
}