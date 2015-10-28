package com.lsyiverson.random.utils;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.IntStream;

public class RandomUtil {

    public static List<Double> generateRandomListNearAvg(double total, int size, int rangePercent, int accuracy) {
        List<Double> result = calculateAvgList(total, size, rangePercent);

        double lastGap = 0;
        do {
            double sum = 0;
            for (double num : result) {
                sum += num;
            }
            sum = new BigDecimal(sum).setScale(accuracy, RoundingMode.HALF_UP).doubleValue();

            double gap = total - sum;
            if (Double.compare(lastGap, gap) == 0) {
                System.out.println("gap:" + gap);
                int index = (int)(Math.random() * size);
                result.set(index, result.get(index) + gap);
                break;
            }
            List<Double> gaps = calculateAvgList(gap, size, rangePercent);
            IntStream.range(0, size)
                .forEach(i -> result.set(i,
                    new BigDecimal(result.get(i) + gaps.get(i)).setScale(accuracy, RoundingMode.HALF_UP).doubleValue()));
            lastGap = gap;
        } while (true);

        formatListAccracy(result, accuracy);
        return result;
    }

    private static void formatListAccracy(List<Double> list, int accuracy) {
        IntStream.range(0, list.size())
            .forEach(i -> list.set(i, new BigDecimal(list.get(i)).setScale(accuracy, RoundingMode.HALF_UP).doubleValue()));
    }

    public static List<Double> calculateAvgList(double total, int size, int rangePercent) {
        List<Double> list = Lists.newArrayList();
        for(int i = 0; i < size; i ++) {
            double avg = getAverage(total, size);
            double range = avg * rangePercent / 100;
            double fluctuation = (Math.random() * range * 2) - range;
            list.add(avg + fluctuation);
        }

        return list;
    }

    private static double getAverage(double total, int size) {
        return total/size;
    }
}
