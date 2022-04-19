package baseball.model;

public enum VerifyType {
    BALL("볼"), NOTHING("낫싱"), STRIKE("스트라이크");

    private final String description;

    VerifyType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
