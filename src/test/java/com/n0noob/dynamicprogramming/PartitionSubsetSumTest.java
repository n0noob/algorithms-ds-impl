package com.n0noob.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionSubsetSumTest {

    private class Tuple {
        int[] sample;
        boolean resultExpected;
        public Tuple(int[] sample, boolean resultExpected) {
            this.sample = sample;
            this.resultExpected = resultExpected;
        }
    }

    private PartitionSubsetSum partitionSubsetSum;
    private Tuple t1;
    private Tuple t2;
    private Tuple t3;

    @BeforeEach
    void setUp() {
        partitionSubsetSum = new PartitionSubsetSum();
        t1 = new Tuple(new int[]{1, 2, 3, 4}, true);
        t2 = new Tuple(new int[]{1, 1, 3, 4, 7}, true);
        t3 = new Tuple(new int[]{2, 3, 4, 6}, false);
    }

    @Test
    void givenArray_whenCanPartitionRecursive_thenReturnResult() {
        Assertions.assertEquals(t1.resultExpected, partitionSubsetSum.canPartitionRecursive(t1.sample));
        Assertions.assertEquals(t2.resultExpected, partitionSubsetSum.canPartitionRecursive(t2.sample));
        Assertions.assertEquals(t3.resultExpected, partitionSubsetSum.canPartitionRecursive(t3.sample));
    }

    @Test
    void givenArray_whenCanPartitionTopDown_thenReturnResult() {
        Assertions.assertEquals(t1.resultExpected, partitionSubsetSum.canPartitionTopDown(t1.sample));
        Assertions.assertEquals(t2.resultExpected, partitionSubsetSum.canPartitionTopDown(t2.sample));
        Assertions.assertEquals(t3.resultExpected, partitionSubsetSum.canPartitionTopDown(t3.sample));
    }

    @Test
    void givenArray_whenCanPartitionBottomUp_thenReturnResult() {
        Assertions.assertEquals(t1.resultExpected, partitionSubsetSum.canPartitionBottomUp(t1.sample));
        Assertions.assertEquals(t2.resultExpected, partitionSubsetSum.canPartitionBottomUp(t2.sample));
        Assertions.assertEquals(t3.resultExpected, partitionSubsetSum.canPartitionBottomUp(t3.sample));
    }

}