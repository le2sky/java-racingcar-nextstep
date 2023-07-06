package racingcargamev2.domain.car;

import racingcargamev2.domain.car.policy.MovePolicy;
import racingcargamev2.domain.car.policy.RandomMovePolicy;

class Car {

    private final Name name;
    private final Position position;
    private final MovePolicy movePolicy;

    private Car(final String name) {
        this.name = Name.from(name);
        this.position = Position.zero();
        this.movePolicy = new RandomMovePolicy();
    }

    private Car(final String name, final MovePolicy movePolicy) {
        this.name = Name.from(name);
        this.position = Position.zero();
        this.movePolicy = movePolicy;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    public static Car of(final String name, final MovePolicy movePolicy) {
        return new Car(name, movePolicy);
    }

    public void move() {
        if (movePolicy.isMovable()) {
            position.move();
        }
    }

    public CarDescription describeSelf() {
        return CarDescription.of(name.getName(), position.getPosition());
    }
}
