package com.n0noob.dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    private Knapsack knapsack;

    @BeforeEach
    void setUp() {
        knapsack = new Knapsack();
    }

    @Test
    void given4Items_whenSolveKnapsackTopDown_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsack.solveKnapsackTopDown(profits, weights, 7);

        Assertions.assertEquals(22, maxProfit);
    }

    @Test
    void given4Items2_whenSolveKnapsackTopDown_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsack.solveKnapsackTopDown(profits, weights, 6);

        Assertions.assertEquals(17, maxProfit);
    }

    @Test
    void given4Items_whenSolveKnapsackBottomUp_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsack.solveKnapsackBottomUp(profits, weights, 7);

        Assertions.assertEquals(22, maxProfit);
    }

    @Test
    void given4Items2_whenSolveKnapsackBottomUp_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsack.solveKnapsackBottomUp(profits, weights, 6);

        Assertions.assertEquals(17, maxProfit);
    }

    @Test
    void given4Items_whenSolveKnapsackBottomUpImproved_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsack.solveKnapsackBottomUpImproved(profits, weights, 7);

        Assertions.assertEquals(22, maxProfit);
    }

    @Test
    void given4Items2_whenSolveKnapsackBottomUpImproved_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsack.solveKnapsackBottomUpImproved(profits, weights, 6);

        Assertions.assertEquals(17, maxProfit);
    }

    @Test
    void given4Items_whenSolveKnapsackBottomUpFurtherImproved_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsack.solveKnapsackBottomUpFurtherImproved(profits, weights, 7);

        Assertions.assertEquals(22, maxProfit);
    }

    @Test
    void given4Items2_whenSolveKnapsackBottomUpFurtherImproved_thenMaxProfitIsReturned() {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = knapsack.solveKnapsackBottomUpFurtherImproved(profits, weights, 6);

        Assertions.assertEquals(17, maxProfit);
    }

}