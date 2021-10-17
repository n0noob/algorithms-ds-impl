package com.n0noob.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsetSumTest {

    private class Tuple {
        int[] sample;
        int sum;
        boolean resultExpected;
        public Tuple(int[] sample, int sum, boolean resultExpected) {
            this.sample = sample;
            this.sum = sum;
            this.resultExpected = resultExpected;
        }
    }

    private SubsetSum subsetSum;
    private Tuple t1;
    private Tuple t2;
    private Tuple t3;

    @BeforeEach
    void setUp() {
        subsetSum = new SubsetSum();
        t1 = new Tuple(new int[]{1, 2, 3, 4}, 5, true);
        t2 = new Tuple(new int[]{1, 1, 3, 4, 7}, 11, true);
        t3 = new Tuple(new int[]{2, 3, 4, 6}, 1, false);
    }

    @Test
    void givenArrays_whenCanPartitionRecursive_thenReturnResult() {
        Assertions.assertEquals(t1.resultExpected, subsetSum.canPartitionRecursive(t1.sample, t1.sum));
        Assertions.assertEquals(t2.resultExpected, subsetSum.canPartitionRecursive(t2.sample, t2.sum));
        Assertions.assertEquals(t3.resultExpected, subsetSum.canPartitionRecursive(t3.sample, t3.sum));
    }

    @Test
    void givenArrays_whenCanPartitionBottomUp_thenReturnResult() {
        Assertions.assertEquals(t1.resultExpected, subsetSum.canPartitionBottomUp(t1.sample, t1.sum));
        Assertions.assertEquals(t2.resultExpected, subsetSum.canPartitionBottomUp(t2.sample, t2.sum));
        Assertions.assertEquals(t3.resultExpected, subsetSum.canPartitionBottomUp(t3.sample, t3.sum));
    }

    @Test
    void givenArrays_whenCanPartitionBottomUpImproved_thenReturnResult() {
        Assertions.assertEquals(t1.resultExpected, subsetSum.canPartitionBottomUpImproved(t1.sample, t1.sum));
        Assertions.assertEquals(t2.resultExpected, subsetSum.canPartitionBottomUpImproved(t2.sample, t2.sum));
        Assertions.assertEquals(t3.resultExpected, subsetSum.canPartitionBottomUpImproved(t3.sample, t3.sum));
    }

}