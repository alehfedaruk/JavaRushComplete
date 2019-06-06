package com.javarush.task.task22.task2213;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(writer, cat);

        String result = writer.toString();
        System.out.println(result);

        cat.name = "";
        cat.age = 0;
        cat.weight = 0;

        System.out.println(cat);

        StringReader reader = new StringReader(result);
        cat = mapper.readValue(reader, Cat.class);

        System.out.println(cat);
    }
}
