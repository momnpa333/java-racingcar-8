package racingcar;

import racingcar.domain.GameController;
import racingcar.factory.GameControllerFactory;

public class Application {

    public static void main(String[] args) {
        GameController gameController = GameControllerFactory.gameController();
        gameController.run();
    }
}
