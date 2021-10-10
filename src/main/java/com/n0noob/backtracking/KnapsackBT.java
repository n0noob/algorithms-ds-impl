package com.n0noob.backtracking;

public class KnapsackBT {
    //Shorter implementation
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return knapsackUtil(profits, weights, capacity, 0, 0);
    }

    //Standard backtracking implementation
    public int solveKnapsack2(int[] profits, int[] weights, int capacity) {
        return knapsackUtil2(profits, weights, capacity, 0);
    }

    private int knapsackUtil(int[] profits, int[] weights, final int capacity, int index, int totalWeight) {
        if(totalWeight >= capacity || index >= profits.length) {
            return 0;
        }

        int profit1 = 0;

        //Choose current element
        if(weights[index] <= (capacity - totalWeight)) {
            profit1 = profits[index] + knapsackUtil(profits, weights, capacity, index+1, totalWeight + weights[index]);
        }

        //Skip current element
        int profit2 = knapsackUtil(profits, weights, capacity, index+1, totalWeight);

        //Return maximum between the two
        return Math.max(profit1, profit2);
    }

    private int knapsackUtil2(int[] profits, int[] weights, int capacity, int index) {
        //Terminating condition
        if(index >= weights.length && capacity <= 0)
            return 0;

        int profit = 0, maxProfit = 0;
        //Propagating step
        for(int i = index; i < weights.length; i++) {
            if(isSafe( weights, capacity, i)) {
                //Choose the ith item
                profit = profits[i] + knapsackUtil2(profits, weights, capacity - weights[i], i+1);
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    private boolean isSafe(int[] weights, int capacity, int i) {
        return weights[i] <= capacity;
    }


}
