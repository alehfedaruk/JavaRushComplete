package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
    View view;
    Provider [] providers;

    public Model(View view, Provider... providers) {
        if (providers == null || (providers.length == 0) || view == null) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity (String city) throws IOException {
        List<Vacancy> vacancyList = new ArrayList<>();
        for (Provider provider : providers) {
            vacancyList.addAll(provider.getJavaVacancies(city));
        }
        view.update(vacancyList);
    }
}
