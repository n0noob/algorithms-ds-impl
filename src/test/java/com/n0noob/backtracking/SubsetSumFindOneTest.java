package com.n0noob.backtracking;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SubsetSumFindOneTest {

    private static SubsetSumFindOne subsetSumFindOne;

    @BeforeAll
    static void init() {
        subsetSumFindOne = new SubsetSumFindOne();
    }

    @Test
    void givenSmallArray_whenHasResult_thenResultIsReturned() {
        final int sum = 8;

        Set<Integer> res = subsetSumFindOne.getSubsetsWithGivenSum(new int[]{1, 2, 3, 4, 5}, sum);
        assertNotNull(res);
        assertEquals(sum, res.stream().reduce(0, (a, b) -> a+b));

        log.info("Result : {}", res);
    }

    @Test
    void givenSmallArray_whenHasNoResult_thenResultIsReturned() {
        final int sum = 14;

        Set<Integer> res = subsetSumFindOne.getSubsetsWithGivenSum(new int[]{1, 2, 3, 4, 5}, sum);
        assertNotNull(res);
        assertEquals(sum, res.stream().reduce(0, (a, b) -> a+b));

        log.info("Result : {}", res);
    }

}