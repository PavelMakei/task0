package by.makei.array.observer;

/**
 * Interface Observable contains methods for subscribing and
 * unsubscribing observers; have a notifyObservers method to notify
 * them about changes in an object.
 */
public interface Observable {
    void attach(CustomArrayObserver observer);
    void detach(CustomArrayObserver observer);
    void notifyObservers();
}
