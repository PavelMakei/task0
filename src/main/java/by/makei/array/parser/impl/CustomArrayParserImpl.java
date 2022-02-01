package by.makei.array.parser.impl;

public class CustomArrayParserImpl {
    private static final CustomArrayParserImpl instance = new CustomArrayParserImpl();
    private static final String REGEX_DELIMITER = "\\s+";
//TODO if it need logger?

    private CustomArrayParserImpl() {
    }

    public static CustomArrayParserImpl getInstance() {
        return instance;
    }

    public int[] convertStringToIntegersArray(String line) {
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
