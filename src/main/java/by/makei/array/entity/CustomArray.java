package by.makei.array.entity;

import by.makei.array.exception.CustomArrayException;
import by.makei.array.observer.CustomArrayObserver;
import by.makei.array.observer.Observable;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CustomArray implements Observable {
    private final String id;
    private static final Logger logger = LogManager.getLogger();
    private int[] intArray;
    private List<CustomArrayObserver> listObservers = new ArrayList<>();

    {
        id = GeneratorId.getInstance().getId();
    }

    public CustomArray(int[] intArray) throws CustomArrayException {
        if (intArray != null && intArray.length > 0) {
            this.intArray = cloneArray(intArray);
        } else {
            logger.log(Level.ERROR, "Array is null or less then 1!");
            throw new CustomArrayException("Invalid array! Can't be implemented.");
        }
    }

    public String getId() {
        return id;
    }

    public boolean setIntArray(int[] intArray) {
        if (intArray != null && this.intArray.length == intArray.length) {
            this.intArray = cloneArray(intArray);
            notifyObservers();
            return true;
        } else {
            logger.log(Level.ERROR, "Array has invalid length!");
            return false;
        }
    }

    public int[] getIntArray() {
        return cloneArray();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if(!id.equals(((CustomArray) o).getId())){
            return false;
        }
        CustomArray arr = (CustomArray) o;
        return Arrays.equals(this.intArray, arr.intArray);
    }

    private int[] cloneArray(int[] intArray) {
        return Arrays.copyOf(intArray, intArray.length);
    }

    private int[] cloneArray() {
        return Arrays.copyOf(intArray, intArray.length);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return Arrays.toString(intArray);
    }

    @Override
    public void attach(CustomArrayObserver observer) {
        listObservers.add(observer);
    }

    @Override
    public void detach(CustomArrayObserver observer) {
        listObservers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        if(!listObservers.isEmpty()) {
            for (CustomArrayObserver observer : listObservers) {
                observer.changeElement(this);
            }
        }
    }
}
