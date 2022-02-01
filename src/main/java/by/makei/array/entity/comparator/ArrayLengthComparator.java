package by.makei.array.entity.comparator;

import by.makei.array.entity.CustomArray;

import java.util.Comparator;

public class ArrayLengthComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray customArray1, CustomArray customArray2) {
        return customArray1.getIntArray().length - customArray2.getIntArray().length;
    }
}
