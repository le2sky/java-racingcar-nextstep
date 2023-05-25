package racingcargame.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    public static final int MINIMUM_ROUND_COUNT = 1;

    @Test
    void 자동차_게임은_라운드의_횟수를_알고있어야_한다() {
        RacingCarGame game = new RacingCarGame(5);
        assertThat(game.getRoundCount()).isEqualTo(5);
    }

    @Test
    void 라운드_횟수가_0_이하인_경우_예외를_발생한다() {
        assertThatThrownBy(() -> {
            new RacingCarGame(0);
            new RacingCarGame(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private class RacingCarGame {

        private int roundCount;

        public RacingCarGame(int roundCount) {
            checkRoundCountRange(roundCount);
            this.roundCount = roundCount;
        }

        private void checkRoundCountRange(int roundCount) {
            if (roundCount < MINIMUM_ROUND_COUNT) {
                throw new IllegalArgumentException();
            }
        }

        public int getRoundCount() {
            return roundCount;
        }
    }
}
