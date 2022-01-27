package by.makei.array.service;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.IncorrectCustomArrayInsertException;
import by.makei.array.exception.IncorrectCustomArrayException;

public interface CustomUtil {
    void replace(CustomArray customArray, int index, int value) throws IncorrectCustomArrayInsertException, IncorrectCustomArrayException;

    void replaceStream(CustomArray customArray, int index, int value) throws IncorrectCustomArrayInsertException, IncorrectCustomArrayException;

    void replaceAll(CustomArray customArray, int find, int valueToReplace) throws IncorrectCustomArrayInsertException, IncorrectCustomArrayException;

    void replaceAllStream(CustomArray customArray, int find, int valueToReplace) throws IncorrectCustomArrayInsertException, IncorrectCustomArrayException;
}
