package racingcar.factory;

import racingcar.domain.GameController;
import racingcar.domain.Parser;
import racingcar.domain.RacingGame;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.Viewer;

public final class GameControllerFactory {

    private GameControllerFactory() {
    }

    public static GameController gameController() {
        return new GameController(racingGame());
    }

    private static RacingGame racingGame() {
        return new RacingGame(viewer(), parser(), randomMoveStrategy());
    }

    private static Viewer viewer() {
        return new Viewer(outputView(), inputView());
    }

    private static Parser parser() {
        return new Parser();
    }

    private static RandomMoveStrategy randomMoveStrategy() {
        return new RandomMoveStrategy();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}

