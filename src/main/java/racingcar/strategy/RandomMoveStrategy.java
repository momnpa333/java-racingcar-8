package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public int generateOptionNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
