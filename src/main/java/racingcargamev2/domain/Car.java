package racingcargamev2.domain;

public class Car {

    private static final int MIN_CONDITION_RANGE = 0;
    private static final int MAX_CONDITION_RANGE = 9;
    private static final int MIN_MOVE_NUM = 4;

    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = Name.of(name);
        this.position = Position.zero();
    }

    public void move(final int condition) {
        checkMoveConditionRange(condition);

        if (condition >= MIN_MOVE_NUM) {
            position.move();
        }
    }

    private void checkMoveConditionRange(final int condition) {
        if (isMoveConditionInRange(condition)) {
            throw new IllegalArgumentException("전진에 필요한 숫자는 0에서 9사이의 숫자입니다.");
        }
    }

    private boolean isMoveConditionInRange(final int condition) {
        return condition < MIN_CONDITION_RANGE || condition > MAX_CONDITION_RANGE;
    }

    public Position getPosition() {
        return position;
    }
}
