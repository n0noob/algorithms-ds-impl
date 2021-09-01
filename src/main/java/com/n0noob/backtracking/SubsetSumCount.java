package com.n0noob.backtracking;

public class SubsetSumCount {

    public int sumSubSetCount(final int[] a, int startIndex, int currSum, final int sum) {
        int count = 0;

        //Terminating step
        if(currSum == sum) {
            count = 1;
            //This is to go ahead even if a solution was found
//            if (startIndex < a.length)
//                return count + sumSubSetCount(a, startIndex, currSum - a[startIndex-1], sum);
        }
        //Propagating step
//        else {
            for(int i = startIndex; i < a.length; i++) {
                count += sumSubSetCount(a, i+1, currSum + a[i], sum);
            }
//        }
        return count;
    }

}
