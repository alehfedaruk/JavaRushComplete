package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        if (data.containsKey(key)) return true;
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        if (data.containsValue(value)) return true;
        return false;
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);

    }

    @Override
    public Long getKey(String value) {
        for (Map.Entry<Long, String> map : data.entrySet()) {
            if (map.getValue().equals(value)) {
                return map.getKey();
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (data.containsKey(key)) return data.get(key);
        return null;
    }
}
