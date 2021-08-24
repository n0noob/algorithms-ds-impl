package com.n0noob.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonianCycleTest {

    final static String CONTAIN_HC = "Graph contains Hamiltonian Cycle";
    final static String DOES_NOT_CONTAIN_HC = "Graph does not contain any Hamiltonian Cycle";

    HamiltonianCycle hc;

    static int[][] graph;

    @BeforeEach
    public void init() {
        hc = new HamiltonianCycle();
    }

    @Test
    @DisplayName(CONTAIN_HC)
    public void whenGraphContainsAtleastOneHC_thenHCIsPrinted() {
        graph = new int[][]{
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        assertTrue(hc.findHamiltonianCycle(graph), CONTAIN_HC);
    }

    @Test
    @DisplayName(DOES_NOT_CONTAIN_HC)
    public void whenGraphDoesNotContainHC_thenFalseIsReturned() {
        graph = new int[][]{{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };

        assertFalse(hc.findHamiltonianCycle(graph), DOES_NOT_CONTAIN_HC);
    }
}