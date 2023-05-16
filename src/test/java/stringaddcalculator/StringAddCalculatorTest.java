package stringaddcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @Test
    void splitAndSum_null_또는_빈문자() {
        int nullResult = StringAddCalculator.splitAndSum(null);
        int emptyResult = StringAddCalculator.splitAndSum("");
        assertThat(nullResult).isEqualTo(0);
        assertThat(emptyResult).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    private static class StringAddCalculator {

        public static int splitAndSum(String expression) {
            if (Optional.ofNullable(expression).isEmpty() || expression.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(expression);
        }
    }
}
