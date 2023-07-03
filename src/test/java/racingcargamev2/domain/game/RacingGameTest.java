package racingcargamev2.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcargamev2.domain.car.CarDescription;

public class RacingGameTest {

    @DisplayName("잔여 라운드가 없다면 게임을 종료한다.")
    @Test
    void isGameEnd() {
        RacingGame game = RacingGame.of(1, List.of("lee"));

        game.race();

        assertThat(game.isEnd()).isTrue();
    }

    @DisplayName("실시간 자동차 현황을 제공한다.")
    @Test
    void race() {
        RacingGame game = RacingGame.of(2, List.of("lee"));

        RoundSummary roundSummary = game.generateRoundSummary();

        assertThat(roundSummary)
                .isEqualTo(RoundSummary.of(List.of(CarDescription.of("lee", 0))));
    }
}
