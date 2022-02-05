package by.makei.array.entity;

import by.makei.array.observer.CustomArrayEvent;
import by.makei.array.observer.CustomArrayObserver;
import by.makei.array.observer.Observable;
import by.makei.array.util.GeneratorId;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomArrayAbstract implements Observable {
    protected final String id;
    private List<CustomArrayObserver> listObservers = new ArrayList<>();

    {
        id = GeneratorId.getInstance().getId();
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
        if (!listObservers.isEmpty()) {
            for (CustomArrayObserver observer : listObservers) {
                observer.changeElement(new CustomArrayEvent(this));
            }
        }
    }

}
