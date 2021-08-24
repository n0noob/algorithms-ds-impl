package com.n0noob.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Matrix {
    public static void print(final int[][] a) {
        Objects.requireNonNull(a);

        int maxDigitCount = Integer.MIN_VALUE;
        int tempNumDigit;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                tempNumDigit = String.valueOf(a[i][j]).length();
                if(tempNumDigit > maxDigitCount)
                    maxDigitCount = tempNumDigit;
            }
        }

        final String format = "%" + maxDigitCount + "s";

        for(int i = 0; i < a.length; i++) {
            var string = Arrays.stream(a[i])
                    .mapToObj(val -> String.format(format, val))
                    .collect(Collectors.joining(" ", "[", "]"));
            System.out.println(string);
        }
    }
}