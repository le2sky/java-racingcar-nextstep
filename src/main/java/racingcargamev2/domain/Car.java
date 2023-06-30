package racingcargamev2.domain;

public class Car {

    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
    }
}
