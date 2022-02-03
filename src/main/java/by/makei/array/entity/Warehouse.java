package by.makei.array.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private Map<String, CustomArrayStatistics> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public CustomArrayStatistics put(String key, CustomArrayStatistics value) {
        return map.put(key, value);
    }

    public CustomArrayStatistics get(String key) {
        return map.get(key);
    }

    public CustomArrayStatistics replace(String key, CustomArrayStatistics value) {
        return map.replace(key, value);
    }

    public CustomArrayStatistics remove (String key) {
        return map.remove(key);
    }

}
