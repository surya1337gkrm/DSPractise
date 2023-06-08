package com.surya.pattern;

public class Pattern {
    public static void printGrid(int n) {
        System.out.println("Printing Grid.");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printRightAngledTriangle(int n) {
        System.out.println("Right Angled triangle.");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printRightAngledTriangleWithNumbers(int n) {
        // printing same pattern using numbers
        System.out.println("Right Angled triangle with numbers.");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printRightAngledTriangleWithRowNumber(int n) {
        System.out.println("Right Angled triangle with row number");
        // same pattern but instead of printing column value, print row number
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printReverseRightAngledTriangle(int n) {
        System.out.println("Reverse Right Angle Triangle.");
        // Printing reverse right angle triangle
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printReverseRightAngledTriangleWithNumbers(int n) {
        System.out.println("Reverse Right Angle Triangle with numbers.");
        // Same pattern using numbers
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printTriangle(int n) {
        System.out.println("Printing triangle");
        // Triangle
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j < n - i + 1; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j < (2 * i); j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 1; j < n - i + 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printReverseTriangle(int n) {
        System.out.println("Printing Reverse Triangle");
        // Reverse Triangle
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j < (2 * (n - i) - 1); j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printRhombus(int n) {
        System.out.println("Printing a Rhombus.\n");
        // Rhombus [ Upper Triangle + Lower triangle ]
        // Upper
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        // Lower
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void printSideTriangle(int n){
        System.out.println("Printing Side Triangle.");
        for(int i=1;i<=2*n-1;i++){
        int stars=i>n ?2*n-i:i;
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printBinaryRightAngledTriangled(int n){
        System.out.println("Printing Binary Right Angled Triangle.\n");
        for(int i=0;i<n;i++){
            int start=i%2==0 ? 1:0;
            for(int j=0;j<=i;j++){
                System.out.print(start+" ");
                start=start==1?0:1;
            }
            System.out.println();
        }
    }

    public static void printNumberPattern01(int n) {
        System.out.println("printing a number pattern\n");
        for(int i=1;i<=n;i++){
            //numbers
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            //spaces
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            //numbers
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void printNumbersPattern02(int n) {
        System.out.println("printing a number pattern - 02\n");
        int num=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(num+1+" ");
                num=num+1;
            }
            System.out.println();
        }
    }

    public static void printAlphabets(int n) {
        System.out.println("Printing Aplhabets\n");
        //In JS: String.fromCharCode('A'.charCodeAt()+1)
        char c='A';
        for (int i = 0; i < n; i++) {
            for(int j=0; j <= i; j++) {
                int res=c+j;
                System.out.print((char)res+" ");
            }
            System.out.println();
        }
    }
}
