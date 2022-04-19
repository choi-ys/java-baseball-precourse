package baseball.model;

import java.util.List;

public class Player {
    private List<Integer> playerNumbers;

    public Player(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
