package by.makei.array.repository;

import by.makei.array.entity.CustomArray;

@FunctionalInterface
public interface Specification {
    boolean specify(CustomArray item);
}
