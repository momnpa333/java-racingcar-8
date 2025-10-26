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

    public void printResult(String result) {
        outputView.printResult(result);
    }

    public String readCarNames() {
        return inputView.readCarNames();
    }

    public String readTryCount() {
        return inputView.readTryCount();
    }

    public void printRoundResult(List<Car> roundResult) {
        outputView.printRoundResult(roundResult);
    }

    public void printFinalWinners(String winners) {
        outputView.printFinalWinners(winners);
    }


}
