package com.n0noob.dynamicprogramming;

public class SubsetSum {
    public boolean canPartitionRecursive(int[] num, int sum) {
        return subSetExists(num, sum, 0);
    }

    private boolean subSetExists(final int[] num, int sum, int currentIndex) {
        //Terminating condition
        if(sum == 0)
            return true;

        if(sum < 0 || currentIndex >= num.length)
            return false;

        //Recursive calls
        return subSetExists(num, sum - num[currentIndex], currentIndex + 1) || subSetExists(num, sum, currentIndex + 1);
    }

    public boolean canPartitionBottomUp(int[] num, int sum) {
        Boolean[][] dp = new Boolean[num.length][sum+1];

        //Base cases where sum is 0
        for(int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }

        //Base cases where only 0th element is taken with variable sum
        for(int s = 0; s <= sum; s++) {
            if(num[0] == s)
                dp[0][s] = true;
            else
                dp[0][s] = false;
        }

        //Actual loop
        for(int i = 1; i < num.length; i++) {
            for(int s = 1; s <= sum; s++) {
                //When current element is picked
                boolean pickCurrentElement = false;
                if(num[i] <= s) {
                    pickCurrentElement = dp[i-1][s - num[i]];
                }
                dp[i][s] = pickCurrentElement || dp[i-1][s];
            }
        }
        return dp[num.length - 1][sum];
    }

    public boolean canPartitionBottomUpImproved(int[] num, int sum) {
        Boolean[] dp = new Boolean[sum+1];

        //Base cases where sum is 0
        dp[0] = true;

        //Base cases where only 0th element is taken with variable sum
        for(int s = 0; s <= sum; s++) {
            if(num[0] == s)
                dp[s] = true;
            else
                dp[s] = false;
        }

        //Actual loop
        for(int i = 1; i < num.length; i++) {
            for(int s = sum; s >= 1; s--) {
                //When current element is picked
                boolean pickCurrentElement = false;
                if(num[i] <= s) {
                    pickCurrentElement = dp[s - num[i]];
                }
                dp[s] = pickCurrentElement || dp[s];
            }
        }
        return dp[sum];
    }
}
