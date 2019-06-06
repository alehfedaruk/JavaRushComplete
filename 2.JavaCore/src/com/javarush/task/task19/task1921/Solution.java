package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        String name;
        String date;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            name = line.replaceAll("\\d", "").trim();
            date = line.replace(name, "").trim();
            PEOPLE.add(new Person(name, simpleDateFormat.parse(date)));
        }

        fileReader.close();
    }
}
