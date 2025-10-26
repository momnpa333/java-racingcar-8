package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {

    private final List<Car> cars;

    private CarGroup(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차 목록이 비어 있습니다.");
        }
        this.cars = new ArrayList<>(cars); // 방어적 복사
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            int optionNumber = moveStrategy.generateOptionNumber();
            car.move(optionNumber);
        }
    }

    public List<Car> findWinners() {
        int winnerLength = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
            .filter(c -> c.getPosition() == winnerLength)
            .toList();
    }
}
