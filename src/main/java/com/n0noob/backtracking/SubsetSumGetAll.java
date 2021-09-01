package com.n0noob.backtracking;

import java.util.*;

public class SubsetSumGetAll {

    public List<List<Integer>> getSubsetSum(final int[] a, final int sum) {

        List<List<Integer>> sol = new ArrayList<>();

        if(sum > 0) {
            getSubsetSumUtil(a, sum, 0, 0, new ArrayDeque<>(), sol);
        }

        return sol;
    }

    private void getSubsetSumUtil(final int[] a, final int sum, int startIndex, int currSum, Deque<Integer> posSol, List<List<Integer>> sol) {
        if(currSum == sum) {
            sol.add(new ArrayList<>(posSol));
            return;
        }

        for(int i = startIndex; i < a.length; i++) {
            posSol.push(a[i]);
            getSubsetSumUtil(a, sum, i+1, currSum + a[i], posSol, sol);
            posSol.pop();
        }

    }

}
