package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
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
        initializeCars(viewer.readCarNames());
        // 자동차 게임 횟수 입력
        int rounds = Integer.parseInt(viewer.readTryCount());
        // 게임 실행
        playGame(rounds);
        // 최종 우승자 출력
        String winners = determineWinners();
        viewer.printFinalWinners(winners);

    }

    private void initializeCars(String input) {
        // 자동차 이름을 기반으로 Car 객체 생성 및 cars 리스트 초기화
        List<String> carNames = parser.parseCarNames(input);
        cars = carNames.stream()
            .map(Car::new)
            .toList();
    }

    private void playGame(int rounds) {
        // 주어진 횟수만큼 게임을 진행
        for (int i = 0; i < rounds; i++) {
            // 각 차수별로 모든 자동차의 위치 업데이트
            updateCarPositions();
            // 차수별 결과 출력
            viewer.printRoundResult(cars);
        }

    }

    private void updateCarPositions() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private String determineWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        List<String> winners = cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .toList();

        return String.join(", ", winners);
    }

}
