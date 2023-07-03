package racingcargamev2.domain.car;

class Car {

    private static final int MIN_CONDITION_RANGE = 0;
    private static final int MAX_CONDITION_RANGE = 9;
    private static final int MIN_MOVE_NUM = 4;

    private final Name name;
    private final Position position;

    private Car(final String name) {
        this.name = Name.of(name);
        this.position = Position.zero();
    }

    public static Car of(final String name) {
        return new Car(name);
    }

    public void move(final int condition) {
        checkMoveConditionInRange(condition);

        if (isMovable(condition)) {
            position.move();
        }
    }

    private void checkMoveConditionInRange(final int condition) {
        if (isMoveConditionInRange(condition)) {
            throw new IllegalArgumentException("전진에 필요한 숫자는 0에서 9사이의 숫자입니다.");
        }
    }

    private boolean isMoveConditionInRange(final int condition) {
        return condition < MIN_CONDITION_RANGE || condition > MAX_CONDITION_RANGE;
    }

    private boolean isMovable(final int condition) {
        return condition >= MIN_MOVE_NUM;
    }

    public CarDescription describeSelf() {
        return CarDescription.of(name.getName(), position.getPosition());
    }
}
