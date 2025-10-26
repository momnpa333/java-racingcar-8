package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Viewer {

    private final OutputView outputView;
    private final InputView inputView;

    public Viewer(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }


    public String readCarNames() {
        return inputView.readCarNames();
    }

    public int readTryCount() {
        return inputView.readTryCount();
    }

    public void printRoundResult(List<Car> roundResult) {
        outputView.printRoundResult(roundResult);
    }

    public void printWinners(List<Car> winners) {
        outputView.printWinners(winners);
    }


}
