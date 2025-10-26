package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 null이면 예외 발생")
    void 자동차_이름이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("비어");
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외 발생")
    void 자동차_이름이_공백이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("비어");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void 자동차_이름이_5자를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Car("abcdef"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("5자");
    }

    @Test
    @DisplayName("자동차 이름이 정상 범위면 생성 성공")
    void 자동차_이름이_정상_범위면_생성에_성공한다() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("optionNumber가 4 이상이면 한 칸 전진한다")
    void 이동값이_4이상이면_한칸_전진한다() {
        Car car = new Car("jun");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(9);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("optionNumber가 4 미만이면 전진하지 않는다")
    void 이동값이_4미만이면_전진하지_않는다() {
        Car car = new Car("woni");
        car.move(3);
        car.move(0);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("copy()는 현재 상태를 동일하게 복제하며 독립적인 객체를 반환한다")
    void copy_메서드는_현재_상태를_복제하면서_독립적인_객체를_반환한다() {
        Car original = new Car("pobi");
        original.move(5); // position = 1

        Car copy = original.copy();

        // 동일한 값
        assertThat(copy.getName()).isEqualTo(original.getName());
        assertThat(copy.getPosition()).isEqualTo(original.getPosition());

        // 독립 객체 (move해도 원본 영향 X)
        copy.move(9);
        assertThat(copy.getPosition()).isEqualTo(2);
        assertThat(original.getPosition()).isEqualTo(1);
    }
}
