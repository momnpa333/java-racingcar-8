package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        Validation.validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int optionNumber) {
        if (optionNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car copy() {
        Car clone = new Car(this.name);
        clone.position = this.position;
        return clone;
    }

    private static class Validation {

        public static void validateName(String name) {
            validateBlank(name);
            validateNameLength(name);
        }

        private static void validateNameLength(String name) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }

        private static void validateBlank(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
        }
    }

}
