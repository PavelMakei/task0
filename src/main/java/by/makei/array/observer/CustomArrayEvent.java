package by.makei.array.observer;

import by.makei.array.entity.CustomArray;
import by.makei.array.entity.CustomArrayAbstract;

import java.util.EventObject;

public class CustomArrayEvent extends EventObject {
    private static String message;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CustomArrayEvent(CustomArrayAbstract source) {
        super(source);
    }
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @param message the String with custom message
     * @throws IllegalArgumentException if source is null
     */
    public CustomArrayEvent(CustomArrayAbstract source, String message) {
        super(source);
    }

    @Override
    public CustomArray getSource() {
        return (CustomArray) super.getSource();
    }
}
