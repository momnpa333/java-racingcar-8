package racingcar.domain;

import java.util.List;

public class Parser {

    public static List<String> parseCarNames(String input) {
        String[] names = input.split(",");
        return List.of(names);
    }
}
