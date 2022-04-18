package baseball.model;

import java.util.List;

// 입력받은 세자리 숫자 저장을 위한 Computer 객체 정의
public class Player {
    private List<Integer> playerNumbers;

    public Player(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
