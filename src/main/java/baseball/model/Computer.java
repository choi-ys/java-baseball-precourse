package baseball.model;

import java.util.List;

// 생성한 세자리 난수 저장을 위한 Computer 객체 정의
public class Computer {

    private List<Integer> computerNumbers;

    public Computer(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
