package by.makei.array.observer;

import by.makei.array.entity.CustomArray;
import java.util.EventObject;

public class CustomArrayEvent extends EventObject {
    private static String message;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CustomArrayEvent(CustomArray source) {
        super(source);
    }
    public CustomArrayEvent(CustomArray source, String message) {
        super(source);
    }

    @Override
    public CustomArray getSource() {
        return (CustomArray) super.getSource();
    }
}
