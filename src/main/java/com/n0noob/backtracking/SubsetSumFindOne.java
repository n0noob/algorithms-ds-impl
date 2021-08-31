package com.n0noob.backtracking;

import java.util.LinkedHashSet;
import java.util.Set;

public class SubsetSumFindOne {

    public Set<Integer> getSubsetsWithGivenSum(final int[] a, final int sum) {
        Set<Integer> sol = new LinkedHashSet<>();

        if(!getSubsetsWithGivenSumUtil(a, sol, 0, 0, sum)) {
            return null;
        }
        return sol;
    }

    private boolean getSubsetsWithGivenSumUtil(final int[] a, Set<Integer> sol, int index, int currSum, final int sum) {
        //Terminating step
        if(currSum == sum) {
            return true;
        }

        //Propagation step
        for(int i = index; i < a.length; i++) {
            if(isSafe(a, i, currSum, sum)) {
                sol.add(a[i]);
                System.out.println("After adding : " + a[i] + " sol is " +  sol);
                if(getSubsetsWithGivenSumUtil(a, sol, i+1, currSum+a[i], sum)) {
                    return true;
                }

                sol.remove(a[i]);
                System.out.println("After removing : " + a[i] + " sol is " +  sol);
            }
        }

        return false;
    }

    private boolean isSafe(final int[] a, int i, final int currSum,final int sum) {
        if(i < a.length && a[i] + currSum <= sum)
            return true;
        return false;
    }

}
