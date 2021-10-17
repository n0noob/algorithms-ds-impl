package com.n0noob.dynamicprogramming;

import java.util.Deque;
import java.util.LinkedList;

public class PartitionSubsetSum {
    public boolean canPartitionRecursive(int[] num) {
        int totalSum = 0;
        //Calculate sum of all the elements
        for (int j : num) {
            totalSum += j;
        }

        if(totalSum % 2 != 0) {
            System.out.println("The given set cannot be partitioned into two subsets with equal sum.");
            return false;
        }

        int halfSum = totalSum/2;

        Deque<Integer> dq = new LinkedList<>();
        if(makePartition(num, halfSum, 0, dq)) {
            System.out.println("PASS : " + dq);
            return true;
        }
        System.out.println("The given set cannot be partitioned into two subsets with equal sum.");
        return false;
    }

    private static boolean makePartition(int[] num, int currentSum, int currentIndex, Deque<Integer> dq) {
        //Terminating step
        if(currentSum == 0)
            return true;

        if(currentSum < 0 || currentIndex >= num.length)
            return false;

        if(makePartition(num, currentSum - num[currentIndex], currentIndex+1, dq)) {
            dq.push(num[currentIndex]);
            return true;
        }

        return makePartition(num, currentSum, currentIndex + 1, dq);
    }

    public boolean canPartitionTopDown(int[] num) {
        int totalSum = 0;
        //Calculate sum of all the elements
        for (int j : num) {
            totalSum += j;
        }

        if(totalSum % 2 != 0) {
            System.out.println("The given set cannot be partitioned into two subsets with equal sum.");
            return false;
        }

        int halfSum = totalSum/2;

        Boolean[][] dp = new Boolean[num.length][halfSum+1];
        if(makePartitionMemoization(num, halfSum, 0, dp)) {
            System.out.println("PASS");
            return true;
        }
        System.out.println("The given set cannot be partitioned into two subsets with equal sum.");
        return false;
    }

    private static boolean makePartitionMemoization(int[] num, int currentSum, int currentIndex, Boolean[][] dp) {
        //Terminating step
        if(currentSum == 0)
            return true;

        if(currentSum < 0 || currentIndex >= num.length)
            return false;

        if(dp[currentIndex][currentSum] == null) {
            if (makePartitionMemoization(num, currentSum - num[currentIndex], currentIndex + 1, dp)) {
                dp[currentIndex][currentSum] = true;
            } else {
                dp[currentIndex][currentSum] = makePartitionMemoization(num, currentSum, currentIndex + 1, dp);
            }
        }

        return dp[currentIndex][currentSum];
    }

    public boolean canPartitionBottomUp(int[] num) {

        int totalSum = 0;
        //Calculate sum of all the elements
        for (int j : num) {
            totalSum += j;
        }

        if(totalSum % 2 != 0) {
            System.out.println("The given set cannot be partitioned into two subsets with equal sum.");
            return false;
        }

        int halfSum = totalSum/2;
        Boolean[][] dp = new Boolean[num.length][halfSum+1];

        //Sum 0 can be achieved without choosing any element
        for(int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        //Considering only 1 element
        for(int hs = 0; hs <= halfSum; hs++) {
            dp[0][hs] = (num[0] == hs);
        }

        for(int i = 1; i < num.length; i++) {
            for(int hs = 1; hs <= halfSum; hs++) {
                //Aim is to get half sum with or without taking current element
                boolean currentElementCanBeAdded = false;
                if(num[i] <= hs) {
                    currentElementCanBeAdded = dp[i-1][hs - num[i]];
                }
                dp[i][hs] = dp[i-1][hs] || currentElementCanBeAdded;
            }
        }

        return dp[num.length - 1][halfSum];
    }
}
