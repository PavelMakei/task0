package by.makei.array.entity;

import by.makei.array.exception.IncorrectCustomArrayInsertException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;


public class CustomArray {
    public static final Logger logger = LogManager.getLogger();
    private int[] intArray;

    public CustomArray(int[] array) {
        this.intArray = cloneArray(array);
    }

    public void setIntArray(int[] intArray) throws IncorrectCustomArrayInsertException {
        if (this.intArray.length == intArray.length) {
            this.intArray = cloneArray(intArray);
        } else {
            logger.log(Level.ERROR,"Array has invalid length!");
            throw new IncorrectCustomArrayInsertException("Invalid array! Can't be implemented.");
        }
    }

    public int[] getCustomIntArray() {
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
        CustomArray arr = (CustomArray) o;
        return Arrays.equals(this.intArray, arr.intArray);
    }

    @Override
    public int hashCode() {
        StringBuilder hashNumber = new StringBuilder("");
        for (int i = 0; i < intArray.length; i++) {
            hashNumber.append(intArray[i] + Integer.toString(0));
        }
        return Integer.parseInt(hashNumber.toString());
    }

    @Override
    public String toString() {
        return Arrays.toString(intArray);
    }

    private int[] cloneArray(int[] intArray) {
        return Arrays.copyOf(intArray, intArray.length);
    }

    private int[] cloneArray() {
        return Arrays.copyOf(intArray, intArray.length);
    }

}
