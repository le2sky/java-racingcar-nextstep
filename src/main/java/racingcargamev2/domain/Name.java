package racingcargamev2.domain;

public class Name {

    private final String name;

    public Name(String name) {
        checkNull(name);
        checkEmptyName(name);
        checkNameLength(name);

        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void checkEmptyName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이 될 수 없습니다.");
        }
    }

    private void checkNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름에 널값을 허용하지 않습니다.");
        }
    }
}
