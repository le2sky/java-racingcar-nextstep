package racingcargamev2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {

    @DisplayName("게임 라운드 수는 적어도 1회 이상이다.")
    @Test
    void racingGameRound() {
        assertThatThrownBy(() -> Round.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임 라운드 수는 적어도 1회 이상입니다.");
    }

    @DisplayName("라운드 수를 감소시킨다.")
    @Test
    void decreaseRound() {
        Round round = Round.of(3);

        round.race();
        round.race();

        assertThat(round).isEqualTo(Round.of(1));
    }

    @DisplayName("잔여 라운드가 존재하지 않다면 라운드 수를 감소할 수 없다.")
    @Test
    void decreaseRound2() {
        Round round = Round.of(1);

        round.race();
        assertThatThrownBy(round::race)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("잔여 라운드가 존재하지 않습니다.");
    }

    @DisplayName("잔여 라운드가 없다면 게임 종료라고 판단한다.")
    @Test
    void isGameEnd() {
        Round round = Round.of(2);

        round.race();
        round.race();

        assertThat(round.isEnd()).isTrue();
    }

    @DisplayName("잔여 라운드가 없다면 게임 진행중이라고 판단한다.")
    @Test
    void isNotGameEnd() {
        Round round = Round.of(2);

        round.race();

        assertThat(round.isEnd()).isFalse();
    }
}
