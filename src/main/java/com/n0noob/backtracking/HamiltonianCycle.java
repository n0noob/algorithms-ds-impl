package com.n0noob.backtracking;

import java.util.Arrays;

public class HamiltonianCycle {
    public boolean findHamiltonianCycle(int[][] g) {
        int[] path = new int[g.length];

        //Initialize path values
        for(int i = 0; i < path.length; i++) {
            path[i] = -1;
        }

        path[0] = 0;

        if(!hamCycle(g, path, 1)) {
            return false;
        }

        System.out.println(Arrays.toString(path));
        return true;
    }

    private boolean hamCycle(int[][] g, int[] path, int pos) {
        //Terminating condition
        //If we have reached final node
        if(pos == g.length) {
            if(g[path[0]][path[pos - 1]] == 1)
                return true;
            return false;
        }

        //Propagating step
        for(int v = 0; v < g.length; v++) {
            if(isSafe(v, g, path, pos)) {
                path[pos] = v;
                if(hamCycle(g, path, pos+1))
                    return true;
                path[pos] = -1;
            }
        }

        return false;

    }

    private boolean isSafe(int v, int[][] g, int[] path, int pos) {

        if(g[path[pos - 1]][v] == 0)
            return false;

        for(int i = 0; i < pos; i++)
            if(path[i] == v)
                return false;

        return true;
    }
}