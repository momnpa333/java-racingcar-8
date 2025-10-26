package racingcar.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-5"})
    @DisplayName("0 이하의 숫자를 입력하면 예외가 발생한다")
    void 시도횟수가_0이하이면_예외가_발생한다(String input) {
        InputView view = new TestableInputView(input);

        assertThatThrownBy(view::readTryCount)
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "10"})
    @DisplayName("1 이상의 숫자를 입력하면 시도 횟수가 정상적으로 반환된다")
    void 시도횟수가_1이상이면_정상적으로_반환된다(String input) {
        InputView view = new TestableInputView(input);

        int result = view.readTryCount();

        assertThat(result).isEqualTo(Integer.parseInt(input));
    }


    static class TestableInputView extends InputView {

        private final String mockInput;

        public TestableInputView(String mockInput) {
            this.mockInput = mockInput;
        }

        @Override
        public String readInput() {
            return mockInput;
        }
    }
}
