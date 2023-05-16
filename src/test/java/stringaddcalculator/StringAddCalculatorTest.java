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

    @Test
    void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    private static class StringAddCalculator {

        public static int splitAndSum(String expression) {
            if (Optional.ofNullable(expression).isEmpty() || expression.isEmpty()) {
                return 0;
            }

            String[] operands = expression.split(",|:");
            if (operands.length > 1) {
                return sum(operands);
            }

            return parseOperand(expression);
        }

        private static int sum(String[] operands) {
            int sum = 0;
            for (String operand : operands) {
                sum += parseOperand(operand);
            }
            return sum;
        }

        private static int parseOperand(String expression) {
            return Integer.parseInt(expression);
        }
    }
}
