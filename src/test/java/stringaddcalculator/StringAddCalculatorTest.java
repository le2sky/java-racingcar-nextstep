package stringaddcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    @Test
    void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("-1,2,3");
        }).isInstanceOf(RuntimeException.class);
    }

    private static class StringAddCalculator {

        public static final String DEFAULT_REGX = ",|:";
        public static final String CUSTOM_REGX = "//(.)\n(.*)";

        public static int splitAndSum(String expression) {
            if (Optional.ofNullable(expression).isEmpty() || expression.isEmpty()) {
                return 0;
            }

            Matcher m = Pattern.compile(CUSTOM_REGX).matcher(expression);
            if (m.find()) {
                String customDelimiter = m.group(1);
                String[] tokens = m.group(2).split(customDelimiter);
                return sum(tokens);
            }

            String[] defaultTokens = expression.split(DEFAULT_REGX);
            if (defaultTokens.length > 1) {
                return sum(defaultTokens);
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
            int target = Integer.parseInt(expression);
            if (target < 0) {
                throw new RuntimeException();
            }

            return target;
        }
    }
}
