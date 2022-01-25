package by.makei.array.service;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomException;

public interface CustomUtil {
    void replace(CustomArray customArray, int index, int value) throws CustomException;

    void replaceStream(CustomArray customArray, int index, int value) throws CustomException;

    void replaceAll(CustomArray customArray, int find, int valueToReplace) throws CustomException;

    void replaceAllStream(CustomArray customArray, int find, int valueToReplace) throws CustomException;
}
