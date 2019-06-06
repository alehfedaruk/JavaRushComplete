package com.javarush.task.task20.task2028;

import org.w3c.dom.Node;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    private ArrayList<Entry> myList = new ArrayList<>();

    public CustomTree() {
        this.root = new Entry<>("0");
        myList.add(root);
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String s) {
        Entry<String> currentEntry = new Entry<>(s);
        return myList.add(currentEntry);
    }

    @Override
    public String remove(int index) {
        return super.remove(index);
    }

    @Override
    public int size() {
        if (myList.size() == 0) {
            return 0;
        }
        return myList.size() - 1;
    }

    public String getParent(String s) {
        return myList.get(indexOf(s)).getParent().toString();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String name) {
            this.elementName = name;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }

        public String getElementName() {
            return elementName;
        }

        public void setElementName(String elementName) {
            this.elementName = elementName;
        }

        public boolean isAvailableToAddLeftChildren() {
            return availableToAddLeftChildren;
        }

        public void setAvailableToAddLeftChildren(boolean availableToAddLeftChildren) {
            this.availableToAddLeftChildren = availableToAddLeftChildren;
        }

        public boolean isAvailableToAddRightChildren() {
            return availableToAddRightChildren;
        }

        public void setAvailableToAddRightChildren(boolean availableToAddRightChildren) {
            this.availableToAddRightChildren = availableToAddRightChildren;
        }

        public Entry<T> getParent() {
            return parent;
        }

        public void setParent(Entry<T> parent) {
            this.parent = parent;
        }

        public Entry<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Entry<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Entry<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Entry<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
