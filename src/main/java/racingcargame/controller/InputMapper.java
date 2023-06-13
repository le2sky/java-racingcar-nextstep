package racingcargame.controller;

class InputMapper {

    static String[] mapToNames(String input) {
        return input.split(",");
    }

    static int mapToRound(String input) {
        return Integer.parseInt(input);
    }
}
