package by.makei.array.entity;

import by.makei.array.observer.CustomArrayObserver;
import by.makei.array.observer.Observable;
import by.makei.array.service.GeneratorId;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomArrayAbstract implements Observable {
    protected final String id;
    protected List<CustomArrayObserver> listObservers = new ArrayList<>();

    {
        id = GeneratorId.getInstance().getId();
    }

    public void getInt() {
    }

    @Override
    public void attach(CustomArrayObserver observer) {
        listObservers.add(observer);
    }

    @Override
    public void detach(CustomArrayObserver observer) {
        listObservers.remove(observer);

    }

    //этот метод отсюда можно и убрать
    @Override
    public abstract void notifyObservers();

}
