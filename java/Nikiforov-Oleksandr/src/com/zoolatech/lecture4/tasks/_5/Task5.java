package com.zoolatech.lecture4.tasks._5;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character) and outputs the result
 * of the selected operation. Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’.
 * The program should work with decimal numbers of any length and precision.
 */

public class Task5 {
    enum Operation {

        PLUS('+') {
            BigInteger apply(BigInteger x, BigInteger y) {
                return x.add(y);
            }
        },
        MINUS('-') {
            BigInteger apply(BigInteger x, BigInteger y) {
                return x.subtract(y);
            }
        },
        MULTIPLY('*') {
            BigInteger apply(BigInteger x, BigInteger y) {
                return x.multiply(y);
            }
        },
        DIVIDE('/') {
            BigInteger apply(BigInteger x, BigInteger y) {
                return x.divide(y);
            }
        },

        MOD('%') {
            BigInteger apply(BigInteger x, BigInteger y) {
                return x.mod(y);
            }
        };
        private final char symbol;

        Operation(char symbol) {
            this.symbol = symbol;
        }

        abstract BigInteger apply(BigInteger x, BigInteger y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input x");
        BigInteger bigX = sc.nextBigInteger();
        System.out.println("Input y");
        BigInteger bigY = sc.nextBigInteger();
        System.out.println("Input symbol: ");
        char symbol = sc.next().charAt(0);
        for (Operation op : Operation.values()) {
            if (symbol == op.symbol) {
                System.out.println(op.apply(bigX, bigY));
                break;
            }
        }
    }
}
