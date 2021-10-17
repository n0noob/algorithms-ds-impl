package com.n0noob.dynamicprogramming;

import com.n0noob.utils.Matrix;
import lombok.extern.slf4j.Slf4j;

public class Knapsack {
    public int solveKnapsackTopDown(int[] profits, int[] weights, int capacity) {

        Integer[][] dp = new Integer[weights.length][capacity + 1];

        return knapsackUtilTopDown(profits, weights, capacity, 0, dp);
    }

    private int knapsackUtilTopDown(int[] profits, int[] weights, final int capacity, int index, Integer[][] dp) {
        if(capacity <= 0 || index >= profits.length) {
            return 0;
        }

        //Check in our cache
        if(dp[index][capacity] != null) {
            return dp[index][capacity];
        }

        int profit1 = 0;

        //Choose current element
        if(weights[index] <= capacity) {
            profit1 = profits[index] + knapsackUtilTopDown(profits, weights, capacity - weights[index], index+1, dp);
        }

        //Skip current element
        int profit2 = knapsackUtilTopDown(profits, weights, capacity, index+1, dp);

        //Maximum between the two profits is actual profit
        dp[index][capacity] = Math.max(profit1, profit2);

        return dp[index][capacity];
    }

    public int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[weights.length][capacity + 1];

        //For each possible capacity when 0th item is taken into consideration
        for(int c = 0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        //For each incremental combination taken when capacity will be 0
        for(int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i < weights.length; i++) {
            for(int c = 1; c <= capacity; c++) {

                int profitWithItem = 0;
                int profitWithoutItem = 0;

                //If current item can be accomodated
                if(weights[i] <= c) {
                    profitWithItem = profits[i] + dp[i-1][c-weights[i]];
                }

                //If current item cannot be accomodated
                profitWithoutItem = dp[i-1][c];

                dp[i][c] = Math.max(profitWithItem, profitWithoutItem);
            }
        }

        printSelectedElements(dp, weights, profits, capacity);

        return dp[weights.length - 1][capacity];
    }

    private void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length-1][capacity];
        for(int i = weights.length-1; i > 0; i--) {
            if(totalProfit != dp[i-1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if(totalProfit != 0)
            System.out.print(" " + weights[0]);
        System.out.println("");
    }

    public int solveKnapsackBottomUpImproved(int[] profits, int[] weights, int capacity) {
        int[] dpPrev;
        int[] dp = new int[capacity + 1];

        //For 0 capacity profit will be 0
        dp[0] = 0;

        //For each possible capacity when 0th item is taken into consideration
        for(int c = 0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[c] = profits[0];
        }

        for(int i = 1; i < weights.length; i++) {
            dpPrev = dp;
            dp = new int[capacity + 1];
            for(int c = 1; c <= capacity; c++) {

                int profitWithItem = 0;
                int profitWithoutItem = 0;

                //If current item can be accomodated
                if(weights[i] <= c) {
                    profitWithItem = profits[i] + dpPrev[c-weights[i]];
                }

                //If current item cannot be accomodated
                profitWithoutItem = dpPrev[c];

                dp[c] = Math.max(profitWithItem, profitWithoutItem);
            }
        }

        return dp[capacity];
    }

    public int solveKnapsackBottomUpFurtherImproved(int[] profits, int[] weights, int capacity) {
        int[] dp = new int[capacity + 1];

        //For 0 capacity profit will be 0
        dp[0] = 0;

        //For each possible capacity when 0th item is taken into consideration
        for(int c = 0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[c] = profits[0];
        }

        for(int i = 1; i < weights.length; i++) {
            for(int c = capacity; c >= 1; c--) {

                int profitWithItem = 0;
                int profitWithoutItem = 0;

                //If current item can be accomodated
                if(weights[i] <= c) {
                    profitWithItem = profits[i] + dp[c-weights[i]];
                }

                //If current item cannot be accomodated
                profitWithoutItem = dp[c];

                dp[c] = Math.max(profitWithItem, profitWithoutItem);
            }
        }

        return dp[capacity];
    }
}
