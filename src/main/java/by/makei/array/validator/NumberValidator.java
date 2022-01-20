package by.makei.array.validator;

import java.util.regex.Pattern;

public class NumberValidator {
    private static final String patternIsnumber ="^[-?\\d+\\s]+$";

    public static boolean fileValidator(String str){
        var pattern = Pattern.compile(patternIsnumber);
        var mather = pattern.matcher(str);
        //TODO check if it has MAX | MIN Integer value?
        return mather.matches();
    }

}
