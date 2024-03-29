package DSA.Recursion;

import java.util.Scanner;

import com.surya.leetcode.unionOfSortedArrays;

import DSA.Hashing.Hashing;
import DSA.Sorting.Sorting;

public class Main {
    public static void main(String[] args) {
        // new Recursion().print();
        System.out.print("Enter a Number: ");
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            // new Recursion().print(n);
            // new Recursion().print(1, n);
            // new Recursion().printReverse(n);
            // new Recursion().printBacktrack(n);
            // new Recursion().printNSum(n, 0);
            // System.out.println(new Recursion().printNSum(n));
            // new Recursion().productN(n, 1);
            // System.out.println(new Recursion().productN(n));

            // new Hashing().hashString("aaabbxxccdeeff");
            int[] arr = { 14, 22, 2, 16, 11, 7, 8, 19, 1 };
            // new Sorting().selectionSort(arr);
            // new Sorting().bubbleSort(arr);
            // new Sorting().insertionSort(arr);
            new Sorting().mergeSort(arr, 0, arr.length - 1);

            int[] arr1 = { 1, 4, 5 };
            int[] arr2 = { 2, 3, 4, 5, 6 };

            new unionOfSortedArrays().unionArrays(arr1, arr2);

        }

    }
}
