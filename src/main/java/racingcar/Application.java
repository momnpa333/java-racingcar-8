package racingcar;

import racingcar.domain.GameController;
import racingcar.domain.Parser;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.Viewer;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Viewer viewer = new Viewer(outputView, inputView);
        Parser parser = new Parser();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        RacingGame racingGame = new RacingGame(viewer, parser, randomMoveStrategy);
        GameController gameController = new GameController(racingGame);
        gameController.run();
    }
}
