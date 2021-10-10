package com.n0noob.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackBTTest {
    private KnapsackBT knapsackBT;

    @BeforeEach
    void setUp() {
        knapsackBT = new KnapsackBT();
    }

    @Test
    void given4Options_whenSolveKnapsack1_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsackBT.solveKnapsack(profits, weights, 7);

        Assertions.assertEquals(22, maxProfit);
    }

    @Test
    void given4Options_whenSolveKnapsack2_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsackBT.solveKnapsack2(profits, weights, 7);

        Assertions.assertEquals(22, maxProfit);
    }
}