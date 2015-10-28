package com.lsyiverson.random;

import com.lsyiverson.random.utils.RandomUtil;

import java.util.List;

public class RandomGenerator {

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java -jar <program>.jar [total] [size] [rangePercent] [accuracy]");
            return;
        }
        double total = Double.parseDouble(args[0]);
        int size = Integer.parseInt(args[1]);
        int rangePercent = Integer.parseInt(args[2]);
        int accuracy = Integer.parseInt(args[3]);

        List<Double> randomListNearAvg = RandomUtil.generateRandomListNearAvg(total, size, rangePercent, accuracy);

        randomListNearAvg.forEach(System.out::println);
    }
}
