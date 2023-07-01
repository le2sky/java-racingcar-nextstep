package racingcargamev2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @DisplayName("잔여 라운드가 없다면 게임을 종료한다.")
    @Test
    void isGameEnd() {
        RacingGame game = RacingGame.of(1);

        game.race();

        assertThat(game.isEnd()).isTrue();
    }
}
