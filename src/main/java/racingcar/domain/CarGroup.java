package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
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

    // ✅ 스냅샷 반환
    public List<Car> getCars() {
        List<Car> snapshot = cars.stream()
            .map(Car::copy) // 각 Car 복제
            .toList();
        return List.copyOf(snapshot); // 완전 불변 리스트로 감싸기
    }

    public List<Car> getWinners() {
        int winnerLength = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
            .filter(c -> c.getPosition() == winnerLength)
            .toList();
    }
}
