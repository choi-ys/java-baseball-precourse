package baseball.service;

import baseball.constants.ErrorMessage;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.constants.NumberBoundary.COUNT;

public class PlayerService {
    public Player generatePlayer() {
        return new Player(uniqueInputNumbers());
    }

    private List<Integer> uniqueInputNumbers() {
        String inputString = Console.readLine();
        inputNumberValidations(inputString);
        return strToIntegerList(inputString);
    }

    private void inputNumberValidations(String inputString) {
        lengthValidate(inputString);
        numberFormatValidate(inputString);
    }

    private void lengthValidate(String str) {
        if (str.trim().length() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private void numberFormatValidate(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private List<Integer> strToIntegerList(String inputString) {
        Set<Integer> inputNumberSet = new LinkedHashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            inputNumberSet.add(charToInt(inputString.charAt(i)));
        }
        uniqueNumberValidate(inputNumberSet);
        return new ArrayList<>(inputNumberSet);
    }

    private int charToInt(char c) {
        return c - '0';
    }

    private void uniqueNumberValidate(Set inputNumberSet) {
        if (inputNumberSet.size() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIQUE_ERROR_MESSAGE);
        }
    }
}
