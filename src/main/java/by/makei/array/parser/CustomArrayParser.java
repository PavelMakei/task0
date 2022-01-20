package by.makei.array.parser;

public class CustomArrayParser {
   private final String REGEX_DELIMITER = "\\s+";

    public int[] convert(String line) {
        line = line.trim();
        String[] numbers = line.split(REGEX_DELIMITER);
        int length = numbers.length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        return array;
    }
}
