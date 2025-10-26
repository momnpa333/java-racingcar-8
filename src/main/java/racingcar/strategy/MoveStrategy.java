package racingcar.strategy;


public interface MoveStrategy {

    /**
     * 자동차 이동 여부를 결정하기 위한 숫자를 생성하거나 조건을 반환한다. 구현체에 따라 무작위, 고정값, 테스트용 등이 될 수 있다.
     */
    int generateOptionNumber();
}
