package baseball.service;

import baseball.constants.NumberBoundary;
import baseball.model.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static baseball.constants.NumberBoundary.COUNT;
import static baseball.constants.NumberBoundary.START_INCLUSIVE;

public class ComputerService {

    public Computer generateComputer() {
        return new Computer(uniqueRandomNumbers());
    }

    // 3개의 난수 생성 및 중복 처리 부
    private List<Integer> uniqueRandomNumbers() {
        Set<Integer> uniqueNumberSet = new LinkedHashSet(); // 순차저장
        while (uniqueNumberSet.size() != COUNT) {
            int generateNumber = generateNumber();
            NumberValidator.numberBoundaryValidate(generateNumber);
            uniqueNumberSet.add(generateNumber);
        }
        return new ArrayList<>(uniqueNumberSet);
    }

    // 1개의 난수 생성 부
    private static int generateNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, NumberBoundary.END_INCLUSIVE);
    }
}
