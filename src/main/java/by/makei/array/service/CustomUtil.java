package by.makei.array.service;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;

public interface CustomUtil {
    boolean replace(CustomArray customArray, int index, int value) throws  CustomArrayException;

    boolean replaceStream(CustomArray customArray, int index, int value) throws CustomArrayException;

    boolean replaceAll(CustomArray customArray, int find, int valueToReplace) throws CustomArrayException;

    boolean replaceAllStream(CustomArray customArray, int find, int valueToReplace) throws CustomArrayException;
}
