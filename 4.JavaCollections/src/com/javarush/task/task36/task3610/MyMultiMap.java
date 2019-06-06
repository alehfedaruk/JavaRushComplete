package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        List<V> valuez = map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        return valuez.size();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if (!map.containsKey(key)) {
            List<V> ls = new ArrayList<>();
            ls.add(value);
            map.put(key, ls);
            return null;
        } else {
            if (map.get(key).size() < repeatCount) {
                List<V> ls = map.get(key);
                ls.add(value);
                map.put(key, ls);

            } else if (map.get(key).size() == repeatCount) {
                List<V> ls = map.get(key);
                ls.remove(0);
                ls.add(value);
                map.put(key, ls);

            }
            List<V> ls = map.get(key);
            return ls.get(ls.size() - 2);
        }
    }

    @Override
    public V remove(Object key) {
        if (!map.containsKey(key)){
            return null;
        }
        List<V> ls = map.get(key);
        Object o = ls.get(0);
        ls.remove(0);
        if (ls.size() == 0) {
            map.remove(key);
        } else {
            map.put((K) key, ls);
        }
        return (V) o;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        return map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        List<V> valuez = map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        return valuez.contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}