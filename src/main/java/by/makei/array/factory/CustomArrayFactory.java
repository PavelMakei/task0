package by.makei.array.factory;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;

/**
 * Interface CustomArray factory contains methods which create CustomArrays.
 */
public interface CustomArrayFactory {
    /**
     * @param intArray integer array.
     * @return CustomArray object.
     * @throws CustomArrayException
     */
    CustomArray createCustomArray(int[] intArray) throws CustomArrayException;
}
