package by.makei.array.parser.impl;

public class CustomArrayParser {
    private static final CustomArrayParser INSTANCE = new CustomArrayParser();
    private final String REGEX_DELIMITER = "\\s+";
//TODO if it need logger?

    private CustomArrayParser() {
    }

    public static CustomArrayParser getInstance() {
        return INSTANCE;
    }

    public int[] convert(String line) {
        line = line.strip();
        String[] numbers = line.split(REGEX_DELIMITER);
        int length = numbers.length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        return array;
    }
}
