package baseball;

import baseball.controller.BullsAndCowsController;

public class Application {
    public static void main(String[] args) {
        BullsAndCowsController bullsAndCowsController = new BullsAndCowsController();
        bullsAndCowsController.run();
    }
}
