package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {

    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String RESULT_SEPARATOR = " : ";
    private static final String PROGRESS_MARK = "-";

    public void printRoundResult(List<Car> roundResult) {
        for (Car car : roundResult) {
            System.out.println(
                car.getName() + RESULT_SEPARATOR + PROGRESS_MARK.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String names = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(FINAL_WINNER_MESSAGE + names);
    }


}
