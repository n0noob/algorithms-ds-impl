package com.n0noob.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsetSumFindOneCountTest {

    private SubsetSumCount subsetSumCount;

    @BeforeEach
    void init() {
        subsetSumCount = new SubsetSumCount();
    }

    @Test
    void givenSmallSet_whenCountIsGreaterThanZero_thenAnswerIsReturned() {
        int res = subsetSumCount.sumSubSetCount(new int[]{4, 5, 2, 1}, 0, 0, 9);
        assertEquals(1, res);
    }

    @Test
    void givenMediumSet_whenCountIsGreaterThanZero_thenAnswerIsReturned() {
        int res = subsetSumCount.sumSubSetCount(new int[]{4, 5, 2, 7, 10}, 0, 0, 12);
        assertEquals(2, res);
    }

    @Test
    void givenMediumSet_whenCountIsZero_thenZeroIsReturned() {
        int res = subsetSumCount.sumSubSetCount(new int[]{1, 400, 20, 60, 45}, 0, 0, 402);
        assertEquals(0, res);
    }
}