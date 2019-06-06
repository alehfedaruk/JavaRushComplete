package com.javarush.task.task22.task2213;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
public class Cat {
    @JsonProperty("realName")
    public String name;
    public int age;
    @JsonIgnore
    public int weight;
    @JsonDeserialize(as = ArrayList.class, contentAs = Cat.class)
    public List<Cat> catList = new ArrayList<>();

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
