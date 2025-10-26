package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    //시도할 횟수는 몇 회인가요?
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).";

    public String readInput() {
        return Console.readLine();
    }

    public String readCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return readInput();
    }

    public int readTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return validateTryNumber(readInput());
    }
    
    private int validateTryNumber(String input) {
        int tryCount = parseToInt(input);
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return tryCount;
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

}
