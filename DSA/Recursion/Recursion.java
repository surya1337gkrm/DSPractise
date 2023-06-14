package DSA.Recursion;

public class Recursion {
    int count = 0;

    public void print() {
        if (count == 3)
            return;
        System.out.println(count);
        count++;
        print();
    }

    // Printing a name n times.
    public void print(int n) {
        if (n == 0)
            return;
        System.out.println("Surya");
        n--;
        print(n);
    }

    // same functionality as previous fn but with 2 params
    public void print(int curr, int n) {
        if (curr > n)
            return;
        System.out.println("Surya");
        print(++curr, n);
    }

    public void printReverse(int n) {
        if (n == 0)
            return;

        System.out.println(n);
        printReverse(--n);
    }

    public void printBacktrack(int n) {
        if (n == 0)
            return;
        printBacktrack(n - 1);
        System.out.println(n);
    }

    public void printNSum(int n, int sum) {
        if (n == 0) {
            System.out.println(sum);
            return;
        }
        printNSum(n - 1, sum + n);
    }

    public int printNSum(int n) {
        if (n == 0) {
            return 0;
        }
        return printNSum(n - 1) + n;
    }

    // factorial using parametrized recursion
    public void productN(int n, int pro) {
        if (n == 1) {
            System.out.println(pro);
            return;
        }
        productN(n - 1, pro * n);
    }

    // factorial using functional recursion
    public int productN(int n) {
        if (n == 1)
            return 1;
        return n * productN(n - 1);
    }

    // using sliding window approach & recursion to reverse an array
    public int[] revArray(int l, int r, int[] arr) {
        if (l >= r)
            return arr;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return revArray(l + 1, r - 1, arr);
    }

    public int[] revArray(int l, int[] array) {
        int n = array.length;
        if (l >= n / 2)
            return array;
        int temp = array[l];
        array[l] = array[n - l - 1];
        array[n - l - 1] = temp;
        return revArray(l + 1, array);
    }

    public boolean isPalindrome(int i, String s) {
        // base condition

        if (i >= s.length() / 2)
            return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;

        return isPalindrome(i + 1, s);
    }

    public int fibonacciWithRecursion(int n) {
        // without caching.
        if (n < 2)
            return n;
        return fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
    }


}
