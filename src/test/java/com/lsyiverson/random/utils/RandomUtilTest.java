package com.lsyiverson.random.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.List;

public class RandomUtilTest {

    @Test
    public void should_gen_correct_size_list_when_gen_random_list() throws Exception {
        List<Double> randomList = RandomUtil.generateRandomListNearAvg(100, 10, 10);

        assertThat(randomList).isNotNull().hasSize(10);
    }
}