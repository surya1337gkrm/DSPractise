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
}
