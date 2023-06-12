package DSA.Recursion;

import java.util.Scanner;

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
            System.out.println(new Recursion().productN(n));

        }

    }
}
