package com.n0noob.backtracking;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SubsetSumGetAllTest {

    private SubsetSumGetAll subsetSumGetAll;

    @BeforeEach
    void init() {
        subsetSumGetAll = new SubsetSumGetAll();
    }

    @Test
    void givenNonZeroSum_whenPassedAsInput_thenGetValidResult() {
        final int sum = 0;
        List<List<Integer>> res = subsetSumGetAll.getSubsetSum(new int[]{4, 5, 2, 7, 10, 3, 1}, sum);

        res.stream().forEach(sol -> assertEquals(sum, sol.stream().reduce(0, (a, b) -> a+b)));
        log.info("Result : {}", res.toString());
    }
}