package com.n0noob.backtracking;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SubsetSumCountTest {

    private SubsetSumCount subsetSumCount;

    @BeforeEach
    void init() {
        subsetSumCount = new SubsetSumCount();
    }

    @Test
    void givenSmallSet_whenCountIsGreaterThanZero_thenAnswerIsReturned() {
        int res = subsetSumCount.sumSubSetCount(new int[]{4, 5, 2, 1}, 0, 0, 9);
        log.info("Result : {}", res);
        assertEquals(1, res);
    }

    @Test
    void givenMediumSet_whenCountIsGreaterThanZero_thenAnswerIsReturned() {
        int res = subsetSumCount.sumSubSetCount(new int[]{4, 5, 2, 7, 10}, 0, 0, 12);
        log.info("Result : {}", res);
        assertEquals(2, res);
    }

    @Test
    void givenMediumSet_whenCountIsZero_thenZeroIsReturned() {
        int res = subsetSumCount.sumSubSetCount(new int[]{1, 400, 20, 60, 45}, 0, 0, 402);
        log.info("Result : {}", res);
        assertEquals(0, res);
    }
}