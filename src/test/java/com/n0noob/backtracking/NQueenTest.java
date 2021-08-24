package com.n0noob.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NQueenTest {

    NQueen nQueen;

    @BeforeEach
    public void init() {
        nQueen = new NQueen();
    }

    @Test
    public void when4SizeIsGivenInInput_thenSolutionGetsPrinted() {
        assertTrue(nQueen.solveNQueen(4));
    }

    @Test
    public void when8SizeIsGivenInInput_thenSolutionGetsPrinted() {
        assertTrue(nQueen.solveNQueen(8));
    }

    @Test
    public void when12SizeIsGivenInInput_thenSolutionGetsPrinted() {
        assertTrue(nQueen.solveNQueen(12));
    }

}