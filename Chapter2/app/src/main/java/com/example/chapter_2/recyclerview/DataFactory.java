package com.example.chapter_2.recyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * author : neo
 * time   : 2019/07/08
 * desc   :
 */
public class DataFactory {

    public static final String[] NAMES = {"Beijing", "Tokyo", "Paris", "London", "Reykjavik", "Jerusalem", "Doha", "Brasilia", "Havana", "Ottawa"};

    public static final int DEFAULT_SIZE = 10;

    public static Data getSingleData(String info) {
        return new Data(info);
    }

    public static List<Data> getData() {
        return getData(DEFAULT_SIZE);
    }

    public static List<Data> getData(int size) {
        if (size > 10) {
            size = 10;
        }
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < size; ++ i) {
            Data data = new Data(NAMES[i]);
            list.add(data);
        }
        return list;
    }
}
