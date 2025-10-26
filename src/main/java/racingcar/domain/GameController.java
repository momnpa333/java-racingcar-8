package racingcar.domain;

public class GameController {

    private final GamePack gamePack;

    public GameController(GamePack gamePack) {
        this.gamePack = gamePack;
    }

    public void run() {
        gamePack.start();
    }
}
