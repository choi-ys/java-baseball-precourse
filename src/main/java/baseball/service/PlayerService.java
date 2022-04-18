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

    // 3개의 숫자 입력 수신 부
    private List<Integer> uniqueInputNumbers() {
        String inputString = Console.readLine();
        inputNumberValidations(inputString);
        return strToIntegerList(inputString);
    }

    // 입력값에 대한 유효성 검사
    private void inputNumberValidations(String inputString) {
        lengthValidate(inputString);
        numberFormatValidate(inputString);
    }

    // 문자열 길이 검사
    private void lengthValidate(String str) {
        if (str.trim().length() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    // 숫자 형식 여부 검사
    private void numberFormatValidate(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    // 입력값 숫자로 변환
    private List<Integer> strToIntegerList(String inputString) {
        Set<Integer> inputNumberSet = new LinkedHashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            inputNumberSet.add(charToInt(inputString.charAt(i)));
        }
        uniqueNumberValidate(inputNumberSet);
        return new ArrayList<>(inputNumberSet);
    }

    // 문자열의 각 자리수를 숫자로 변환
    private int charToInt(char c) {
        return c - '0';
    }

    // 입력값 중복 여부 검사
    private void uniqueNumberValidate(Set inputNumberSet) {
        if (inputNumberSet.size() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIQUE_ERROR_MESSAGE);
        }
    }
}
