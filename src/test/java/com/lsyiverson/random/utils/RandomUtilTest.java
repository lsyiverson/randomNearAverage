package com.lsyiverson.random.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.List;

public class RandomUtilTest {

    @Test
    public void should_gen_correct_size_list_when_gen_random_list() throws Exception {
        List<Double> randomList = RandomUtil.generateRandomListNearAvg(100, 10, 10, 2);

        randomList.stream().forEach(System.out::println);

        assertThat(randomList).isNotNull().hasSize(10);
    }

    @Test
    public void should_get_same_sum_after_calculate_random_array() throws Exception {
        List<Double> randomList = RandomUtil.generateRandomListNearAvg(0.3, 10, 10, 4);

        double sum = 0;
        for (double num : randomList) {
            System.out.println(num);
            sum += num;
        }

        System.out.println(sum);
        assertThat(sum - 0.3).isLessThan(Math.pow(10, 4));
    }
}