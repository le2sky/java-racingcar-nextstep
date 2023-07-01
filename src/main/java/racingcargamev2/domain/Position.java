package racingcargamev2.domain;

import java.util.Objects;

public class Position {

    private int position;

    private Position(final int position) {
        checkNegativePosition(position);

        this.position = position;
    }

    public static Position zero() {
        return new Position(0);
    }

    public static Position of(final int position) {
        return new Position(position);
    }

    private void checkNegativePosition(final int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 음수일 수 없습니다.");
        }
    }

    public void move() {
        position++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
