package racingcar.domain;

import java.util.List;

public class Parser {

    private static final String DELIMITER = ",";

    public List<String> parseCarNames(String input) {
        String[] names = input.split(DELIMITER);
        return List.of(names);
    }
}
