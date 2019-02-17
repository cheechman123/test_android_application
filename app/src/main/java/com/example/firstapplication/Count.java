package com.example.firstapplication;

import java.math.BigInteger;

public class Count {

    private static final double firstNumber = 1;
    private static final double secondNumber = 1;

    public static double recursiveMethod(double currentNumber) {
        if (currentNumber == 0) {
            return 0;
        } else if (currentNumber == 1) {
            return 1;
        }

        return recursiveMethod(currentNumber - 1)
                + recursiveMethod(currentNumber - 2);

    }

    public static double linearMethod(double requiredCount) {
        double currentSum = 0;
        double first = firstNumber;
        double second = secondNumber;

        if (requiredCount <= 1) {
            return requiredCount < 2 && requiredCount > 0 ? 1 : 0;
        }

        for (int i = 2; i < requiredCount; i++) {
            currentSum = first + second;
            first = second;
            second = currentSum;
        }
        return currentSum;
    }

    // матричное умножение двух матриц размера 2 на 2
    private static BigInteger[][] matrixMultiply(BigInteger[][] a, BigInteger[][] b) {
        return new BigInteger[][]{
                {a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])), a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])), a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))},
        };
    }

    // возведение матрицы размера 2 на 2 в степень n
    private static BigInteger[][] matrixPowerFast(BigInteger[][] a, double n) {
        if (n == 0) {
            return new BigInteger[][]{{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}
            };
        } else if (n % 2 == 0) {
            return matrixPowerFast(matrixMultiply(a, a), n / 2);
        } else {
            return matrixMultiply(matrixPowerFast(a, n - 1), a);
        }
    }

    // функция, возвращающая n-ое число Фибоначчи
    public static BigInteger matrixMethod(double requiredNumber) {
        if (requiredNumber == 0) {
            return BigInteger.ZERO;
        }

        BigInteger[][] a = {
                {BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}
        };
        BigInteger[][] powerOfA = matrixPowerFast(a, requiredNumber - 1);
        // nthFibonacci = powerOfA[0][0] * F_1 + powerOfA[0][0] * F_0 = powerOfA[0][0] * 1 + powerOfA[0][0] * 0
        BigInteger nthFibonacci = powerOfA[0][0];
        return nthFibonacci;
    }

}
