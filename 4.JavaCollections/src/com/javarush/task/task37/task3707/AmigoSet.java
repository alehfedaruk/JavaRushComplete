package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet <E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object ();
    private transient HashMap <E, Object> map;

    public AmigoSet () {
        map = new HashMap<>();
    }

    public AmigoSet (Collection<? extends E> collection) {
        int capacity = Math.max(16, (int)(collection.size()/.75f)+1);
        map = new HashMap<>(capacity);
        collection.forEach (o -> map.put (o,PRESENT));
    }

    @Override
    public Iterator iterator () {
        return map.keySet ().iterator ();
    }

    @Override
    public int size () {
        return map.size ();
    }

    @Override
    public Spliterator spliterator () {
        return null;
    }

    @Override
    public boolean removeIf (Predicate filter) {
        return false;
    }

    @Override
    public Stream stream () {
        return null;
    }

    @Override
    public Stream parallelStream () {
        return null;
    }

    @Override
    public void forEach (Consumer action) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean add (Object o) {
        E key = (E) o;
        if (map.put (key, PRESENT) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEmpty () {
        return map.isEmpty ();
    }

    @Override
    public boolean contains (Object o) {
        return map.containsKey (o);
    }

    @Override
    public boolean remove (Object o) {
        return map.remove (o) != null;
    }

    @Override
    public void clear () {
        map.clear ();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object clone () throws InternalError {
        try {
            AmigoSet<E> amigoSet = new AmigoSet<> ();
            amigoSet.map.putAll ((Map) this.map.clone ());
            return amigoSet;
        } catch (Exception e) {
            throw new InternalError (e);
        }
    }

    private void writeObject (ObjectOutputStream objectOutputStream) throws IOException, NoSuchFieldException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(map.size());
        objectOutputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        map.forEach((e, o) -> {
            try {
                objectOutputStream.writeObject(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void readObject (ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int size = objectInputStream.readInt();
        float loadfactor = objectInputStream.readFloat();
        int capacity = objectInputStream.readInt();
        map = new HashMap<>(capacity, loadfactor);

        @SuppressWarnings("unchecked")
        E e = (E) objectInputStream.readObject();
        for (int i = 0; i < size; i++) {
            map.put(e, PRESENT);
        }
    }
}
