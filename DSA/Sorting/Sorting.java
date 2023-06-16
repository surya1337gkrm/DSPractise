package DSA.Sorting;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
    // selection sort will select minimum value of the array in each iteration(ith
    // iteration) and
    // swaps the minimum value with the i'th value of the array
    public void selectionSort(int[] arr) {
        // ignore the last element as if all other elements are sorted, then last
        // element will be max
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // check min value between i to n-1(last el)
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;

                // this is unnecessary -> printing new array when swapping is done.
                for (int a : arr) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }

        }

    }

    // in bubble sort, we will compare two adjacent elements and swap if they aren't
    // in sorted order.
    // We will continue this process until the entire array is sorted

    // avg/worst case : O(n^2) | Best case: O(n) for already sorted array.
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // ignore n-1 element, as in n-2 iteration, both n-2 & n-1 will be checked.
            boolean swapDone = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapDone = true;

                    // Unnecessary loop -> used to print resultant array if swapping is done.
                    for (int a : arr) {
                        System.out.print(a + " ");
                    }
                    System.out.println();
                }
            }
            System.out.println();

            // if there's no swapping done [ or everything is in sorted order ]
            // there's no point in checking further. So we can stop iterating.
            if (!swapDone) {
                break;
            }
        }
    }

    // insertion sort: takes a sub-array of size i and sort each element
    // i.e, consioders i'th element and iteratively compares with it's previous
    // element and swaps in it's not in sorted order
    public void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;

                for (int a : arr) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private void mergeSubArrays(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low; // starting index of first half
        int right = mid + 1; // starting index of seconf half

        // continue this until there are elements left in both halfs of the array
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if there are still elements prsnt in first half of the array
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // if there are still elements in second half of the array
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transferring the elements from temp arary to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // after sorting the sub arrays, we need to merge them
        mergeSubArrays(arr, low, mid, high);

        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
