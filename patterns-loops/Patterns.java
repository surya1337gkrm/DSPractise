// import com.surya.pattern.*;

// import java.util.Collections;

import com.surya.math.*;

import DSA.Recursion.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.surya.leetcode.*;

class Patterns {
    public static void main(String[] args) {
        // Pattern.printGrid(5);
        // Pattern.printRightAngledTriangle(5);
        // Pattern.printRightAngledTriangleWithNumbers(5);
        // Pattern.printRightAngledTriangleWithRowNumber(6);
        // Pattern.printReverseRightAngledTriangle(6);
        // Pattern.printReverseRightAngledTriangleWithNumbers(8);
        // Pattern.printTriangle(8);
        // Pattern.printReverseTriangle(4);
        // Pattern.printRhombus(6);
        // Pattern.printSideTriangle(6);
        // Pattern.printBinaryRightAngledTriangled(6);
        // Pattern.printNumberPattern01(4);
        // Pattern.printNumbersPattern02(5);
        // Pattern.printAlphabets(5);
        // Pattern.printReverseAlphabets(5);
        // Pattern.printSameCharacters(5);
        // Pattern.printPattern17(5);
        // Pattern.printPattern18(5);
        // Pattern.printPattern19(5);
        // Pattern.printPattern20(5);
        // Pattern.printPattern21(4);

        // int num=789;
        // String[] arr=Integer.toString(num).split("");
        // for(String s:arr){
        // System.out.println((s)+1);
        // }

        // System.out.println(MathFun.getDigits(7789));
        // System.out.println(MathFun.getLength(7789));

        // System.out.println(new reverseNumber().reverse(-901000));
        // System.out.println(new validPalindrome().isPalindrome("race a car"));
        // System.out.println(new armstrongNumber().isArmstrongNumber(371));
        // new printAllDivisors().printDivisors(442);
        // System.out.println(new GCDofTwoNumbers().gcd(20, 50));
        // System.out.println(new validPrime().isValidPrime(134));

        // Scanner sc = new Scanner(System.in);
        // System.out.println(sc.nextInt());

        // System.out.println(new MathFun().getCommonFactors(850,442));
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        // int[] revArray = new Recursion().revArray(0, arr.length - 1, arr);
        int[] revArray = new Recursion().revArray(0, arr);
        // for (int n : revArray) {
        // System.out.print(n + " ");
        // }

        // System.out.println(new Recursion().isPalindrome(0, "MADAM"));
        System.out.println(new Recursion().fibonacciWithRecursion(6));

    }
}