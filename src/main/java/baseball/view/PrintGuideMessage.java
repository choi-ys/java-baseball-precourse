package baseball.view;

import baseball.constants.GuideMessage;

public class PrintGuideMessage {

    public static void printInputMessage() {
        System.out.print(GuideMessage.INPUT_NUMBER_MESSAGE);
    }

    public static void printCorrectAnswerMessage() {
        System.out.println(GuideMessage.CORRECT_ANSWER_MESSAGE);
    }

    public static void printContinueGameMessage() {
        System.out.println(GuideMessage.CONTINUE_GAME_MESSAGE);
    }

    public static void notingMessage() {
        System.out.println("낫싱");
    }

    public static boolean inGameMessage(int ballCount, int strikeCount) {
        String inGameMessage = "";
        String ballMessage = "";
        String strikeMessage = "";
        if (ballCount != 0) {
            ballMessage = messageFormat(ballCount, "볼");
            inGameMessage = ballMessage;
        }

        if (strikeCount != 0) {
            strikeMessage = messageFormat(strikeCount, "스트라이크");
            inGameMessage = strikeMessage;
        }

        if (ballCount > 0 && strikeCount > 0) {
            inGameMessage = "";
            inGameMessage = ballMessage + " " + strikeMessage;
        }
        System.out.println(inGameMessage);

        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    private static String messageFormat(int count, String type) {
        if (count != 0) {
            return String.format("%d%s", count, type);
        }
        return "";
    }
}
