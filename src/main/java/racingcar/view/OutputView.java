package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printRoundResult(List<Car> roundResult) {
        for (Car car : roundResult) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printFinalWinners(String winners) {
        System.out.println("최종 우승자: " + winners);
    }


}
