package racingcar.domain;

import java.util.List;
import racingcar.view.Viewer;

public class RacingGame {

    private final Viewer viewer;
    private final Parser parser;
    private final MoveStrategy moveStrategy;
    private CarGroup carGroup;


    public RacingGame(Viewer viewer, Parser parser, MoveStrategy moveStrategy) {
        this.viewer = viewer;
        this.parser = parser;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        initializeCarGroup(viewer.readCarNames());
        int rounds = Integer.parseInt(viewer.readTryCount());
        playGame(rounds);
        viewer.printWinners(carGroup.getWinners());
    }

    // 입력된 자동차 이름을 파싱하여 자동차 객체 생성 및 CarGroup 초기화
    private void initializeCarGroup(String input) {
        List<String> carNames = parser.parseCarNames(input);
        List<Car> cars = carNames.stream()
            .map(Car::new)
            .toList();
        this.carGroup = new CarGroup(cars);
    }

    private void playGame(int rounds) {
        for (int i = 0; i < rounds; i++) {
            carGroup.moveCars(moveStrategy);
            viewer.printRoundResult(carGroup.getCars());
        }
    }

}
