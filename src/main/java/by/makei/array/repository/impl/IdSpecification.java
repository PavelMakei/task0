package by.makei.array.repository.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.repository.Specification;

public class IdSpecification implements Specification {
    private final String id;
    public IdSpecification(String id){
        this.id = id;
    }
    @Override
    public boolean specify(CustomArray item){
        return item.getId() == id;
    }
}
