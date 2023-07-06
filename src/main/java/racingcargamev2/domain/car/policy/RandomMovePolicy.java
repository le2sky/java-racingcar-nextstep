package racingcargamev2.domain.car.policy;

public class RandomMovePolicy implements MovePolicy {

    @Override
    public boolean isMovable() {
        return false;
    }
}
