package racingcargame.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    public final String[] carNames = new String[]{"pobi", "lsky", "ksky"};

    @Test
    void 자동차_게임은_라운드의_횟수를_알고있어야_한다() {
        RacingCarGame game = new RacingCarGame(5, carNames);
        assertThat(game.getRoundCount()).isEqualTo(5);
    }

    @Test
    void 라운드_횟수가_0_이하인_경우_예외를_발생한다() {
        assertThatThrownBy(() -> {
            new RacingCarGame(0, carNames);
            new RacingCarGame(-1, carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_게임은_게임의_참여자를_알고있어야_한다() {
        RacingCarGame game = new RacingCarGame(5, carNames);
        assertThat(game.getParticipantCarCount()).isEqualTo(3);
    }

    @Test
    void 자동차_게임의_참여자가_null인_경우_예외를_발생한다() {
        assertThatThrownBy(() -> {
            new RacingCarGame(5, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_게임의_참여자가_1명_미만일_경우_예외를_발생한다() {
        assertThatThrownBy(() -> {
            new RacingCarGame(5, new String[]{});
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잔여_라운드_수가_없을_때_플레이_요청을_하면_예외를_발생한다() {
        assertThatThrownBy(() -> {
            RacingCarGame game = new RacingCarGame(1, carNames);
            game.play();
            game.play();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
