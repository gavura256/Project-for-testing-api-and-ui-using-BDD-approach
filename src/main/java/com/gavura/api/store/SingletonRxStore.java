package com.gavura.api.store;

import java.util.HashMap;
import java.util.Map;

public class SingletonRxStore {
    private static SingletonRxStore instance = null;
    private final Map<String, Object> rxStore = new HashMap<>();

    private SingletonRxStore() {}

    public static SingletonRxStore getInstance() {
        if (instance == null) {
            instance = new SingletonRxStore();
        }
        return instance;
    }

    public Object putDataIntoStore(String key, Object value) {
        return rxStore.put(key, value);
    }

    public Object getDataFromStore(String key) {
        return rxStore.get(key);
    }
}
