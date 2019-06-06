package com.javarush.task.task33.task3312;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    @JsonDeserialize(as = ArrayList.class, contentAs = Animal.class)
    public List<Animal> animals = new ArrayList<>();

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY ,property = "type")
    @JsonSubTypes({

    })
    public static class Animal {
        public Animal(String name) {
            this.name = name;
        }

        public String name;
    }

    @JsonTypeName(value = "dog")
    public static class Dog extends Animal {

        public double barkVolume;

        @JsonCreator
        public Dog(@JsonProperty("name") String name) {
            super(name);
        }
    }

    @JsonTypeName(value = "cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        @JsonCreator
        public Cat(@JsonProperty("name") String name) {
            super(name);
        }
    }
}