package com.lsyiverson.random.utils;

import com.google.common.collect.Lists;

import java.util.List;

public class RandomUtil {

    public static List<Double> generateRandomListNearAvg(double total, int size, int rangePercent) {
        List<Double> list = Lists.newArrayList();

        for(int i = 0; i < size; i ++) {
            list.add(Math.random());
        }
        return list;
    }
}
