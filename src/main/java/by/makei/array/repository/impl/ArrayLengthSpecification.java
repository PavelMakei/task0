package by.makei.array.repository.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.repository.Specification;

public class ArrayLengthSpecification implements Specification {
    private final int minLength;
    private final int maxLength;

    public ArrayLengthSpecification(int maxLength){
        this.maxLength = maxLength;
        this.minLength = 0;
    }
    public ArrayLengthSpecification(int minLength, int maxLength){
        this.maxLength = maxLength;
        this.minLength = minLength;
    }

    @Override
    public boolean specify(CustomArray item) {
        return  (item.getIntArray().length >= minLength && item.getIntArray().length < maxLength);// славная традиция Java не включать последний
    }
}
