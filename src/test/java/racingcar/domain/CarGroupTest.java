package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MoveStrategy;

// 테스트용 MoveStrategy (항상 전진 / 항상 멈춤)
class AlwaysMoveStrategy implements MoveStrategy {

    @Override
    public int generateOptionNumber() {
        return 9; // 항상 4 이상 → 전진
    }
}

class NeverMoveStrategy implements MoveStrategy {

    @Override
    public int generateOptionNumber() {
        return 0; // 항상 4 미만 → 멈춤
    }
}

class CarGroupTest {

    @Test
    @DisplayName("자동차 목록이 null이면 예외 발생")
    void 자동차_목록이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> new CarGroup(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("비어 있습니다");
    }

    @Test
    @DisplayName("자동차 목록이 비어 있으면 예외 발생")
    void 자동차_목록이_비어_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new CarGroup(List.of()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("moveCars() 호출 시 전략에 따라 자동차가 이동한다")
    void moveCars_호출시_전략에_따라_자동차가_이동한다() {
        // given
        Car pobi = new Car("pobi");
        Car jun = new Car("jun");
        CarGroup group = new CarGroup(List.of(pobi, jun));
        MoveStrategy 항상_전진 = new AlwaysMoveStrategy();
        MoveStrategy 항상_멈춤 = new NeverMoveStrategy();

        // when
        group.moveCars(항상_전진);
        group.moveCars(항상_멈춤);

        // then
        assertThat(pobi.getPosition()).isEqualTo(1); // 전진
        assertThat(jun.getPosition()).isEqualTo(1);  // 전진 (1번만 움직였음)
    }

    @Test
    @DisplayName("getCars()는 스냅샷을 반환하며 내부 상태 변경 불가")
    void getCars는_스냅샷을_반환하며_내부_상태가_변경되지_않는다() {
        // given
        CarGroup group = new CarGroup(List.of(new Car("pobi"), new Car("jun")));

        // when
        List<Car> snapshot = group.getCars();

        // then
        assertThat(snapshot).hasSize(2);
        assertThatThrownBy(() -> snapshot.add(new Car("hihi")))
            .isInstanceOf(UnsupportedOperationException.class);

        // 스냅샷 변경이 원본에 영향 주지 않음
        int originalPos = snapshot.get(0).getPosition();
        group.moveCars(new AlwaysMoveStrategy());
        assertThat(snapshot.get(0).getPosition()).isEqualTo(originalPos);
    }

    @Test
    @DisplayName("getWinners()는 최대 position의 자동차를 반환한다")
    void getWinners는_최대_위치의_자동차만_반환한다() {
        // given
        Car pobi = new Car("pobi");
        Car jun = new Car("jun");
        Car woni = new Car("woni");
        CarGroup group = new CarGroup(List.of(pobi, jun, woni));

        // when
        pobi.move(9); // 1
        jun.move(9);  // 1
        woni.move(0); // 0
        List<Car> winners = group.getWinners();

        // then
        assertThat(winners).extracting(Car::getName)
            .containsExactlyInAnyOrder("pobi", "jun");
    }
}
