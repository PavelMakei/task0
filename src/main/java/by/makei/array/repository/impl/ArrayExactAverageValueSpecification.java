package by.makei.array.repository.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.repository.Specification;
import by.makei.array.service.impl.CustomMathImpl;

public class ArrayExactAverageValueSpecification implements Specification {
    private final double averageValue;

    public ArrayExactAverageValueSpecification(double averageValue){
     this.averageValue = averageValue;
    }
    @Override
    public boolean specify(CustomArray item) {
        return averageValue == CustomMathImpl.getInstance().findAverage(item);
    }
}

