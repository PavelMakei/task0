package by.makei.array.repository.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.repository.Specification;
import by.makei.array.service.CustomMath;
import by.makei.array.service.impl.CustomMathImpl;

public class ArrayMinToMaxAverageSpecification implements Specification {
    private final double minValue;
    private final double maxValue;

    public ArrayMinToMaxAverageSpecification(double minValue, double maxValue){
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean specify(CustomArray item) {
        CustomMath service = CustomMathImpl.getInstance();
        return (minValue<=service.findAverage(item) && maxValue>service.findAverage(item));//славная традиция Java
    }
}
