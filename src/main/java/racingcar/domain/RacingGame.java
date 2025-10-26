package racingcar.domain;

import java.util.List;
import racingcar.view.Viewer;

public class RacingGame {

    private final Viewer viewer;
    private final Parser parser;
    private List<Car> cars;

    public RacingGame(Viewer viewer, Parser parser) {
        this.viewer = viewer;
        this.parser = parser;
    }

    public void start() {
        // 자동차 이름 입력 및 자동차 초기화
        // 자동차 게임 횟수 입력
        // 게임 실행
        // 차수별 결과 출력
        // 최종 우승자 출력
    }

    private void initializeCars(String input) {
        // 자동차 이름을 기반으로 Car 객체 생성 및 cars 리스트 초기화
    }

    private void playGame(int rounds) {
        // 주어진 횟수만큼 게임을 진행
        // 각 차수별로 모든 자동차의 위치 업데이트
    }

}
