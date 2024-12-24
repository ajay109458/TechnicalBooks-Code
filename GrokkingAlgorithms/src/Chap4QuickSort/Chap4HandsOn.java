package Chap4QuickSort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chap4HandsOn {
    public static void main(String[] args) {
        validateQuestion1();
        validateQuestion2();
        validateQuestion3();
        validateQuestion4();
        validateQuestion5();
        validateQuestion6();
        validateQuestion7();
        validateQuestion8();
        validateQuestion9();
        validateQuestion10();

    }

    public static void validateQuestion10() {
        int[] nums = IntStream.generate(() -> new Random().nextInt(10000)).limit(10000).toArray();
        long start = System.nanoTime();
        quickSort(nums, 0, nums.length - 1);
        long end = System.nanoTime();
        System.out.println("Execution time in ms: " + (end - start)/1000000);
    }

    public static void validateQuestion9() {
        //TODO: input from user
    }

    public static void validateQuestion8() {
        int[] arr = {3, 1, 4, 2};

        // Print the initial state of the array
        System.out.println("Initial Array: " + Arrays.toString(arr));

        // Start quicksort and recursion tree
        quickSort(arr, 0, arr.length - 1, 0);
    }

    public static void quickSort(int[] arr, int low, int high, int depth) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Print the current state of the array and partition
            printRecursionStep(arr, low, high, pivotIndex, depth);

            // Recursively sort the left and right subarrays
            quickSort(arr, low, pivotIndex - 1, depth + 1);
            quickSort(arr, pivotIndex + 1, high, depth + 1);
        }
    }

    // Print the current step in the recursion tree
    private static void printRecursionStep(int[] arr, int low, int high, int pivotIndex, int depth) {
        // Indent to show recursion depth
        String indent = "  ".repeat(depth);
        System.out.println(indent + "Array: " + Arrays.toString(Arrays.copyOfRange(arr, low, high + 1)) +
                ", Pivot: " + arr[pivotIndex] + ", Depth: " + depth);
    }


    public static void validateQuestion7() {
        int[] nums = {8, 4, 2, 6, 9};
        quickSort(nums, 0, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void validateQuestion6() {
        String[] input = {"apple", "banana", "cherry", "date"};
        qSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    public static void qSort(String[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            qSort(arr, left, partitionIndex - 1);
            qSort(arr, partitionIndex + 1, right);
        }
    }

    public static  int partition(String[] arr, int left, int right) {
        int pivot = left;

        int i = left;
        int j = left + 1;

        while (j < right) {
            if (arr[i].compareTo(arr[pivot]) < 0) {
                i++;
                swap(arr, i, j);
            }
            j++;
        }

        swap(arr, i, left);
        return i;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void validateQuestion5() {
        int[] nums = {4, 5, 4, 6, 7};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void validateQuestion4() {
        int[] nums = {5, 2, 9, 1, 6};
        Map<String, int[]> map = partitionFunction(nums, 5);
        System.out.println(map);
    }

    public static Map<String, int[]> partitionFunction(int[] nums, int pivot) {
        int[] leftList = Arrays.stream(nums)
                .filter(num -> num < pivot)
                .toArray();

        int[] rightList = Arrays.stream(nums)
                .filter(num -> num > pivot)
                .toArray();

        Map<String, int[]> map = new HashMap<>();
        map.put("left", leftList);
        map.put("right", rightList);
        return map;
    }

    public static void validateQuestion3() {
        int[] nums = {7, 3, 9, 1};
        qSortDesc(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void qSortDesc(int[] nums, int left, int right) {
        if (left < right) {
            int index = partitionDesc(nums, left, right);
            qSortDesc(nums, left, index - 1);
            qSortDesc(nums, index + 1, right);
        }
    }

    public static int partitionDesc(int[] nums, int left, int right) {
        int pivot = nums[left];

        int i = left;
        int j = left+1;

        while (j <= right) {
            if (nums[j] > pivot) {
                i++;
                swap(nums, i, j);
            }
            j++;
        }

        swap(nums, left, i);
        int pivotIndex = i;
        return pivotIndex;
    }

    public static void validateQuestion2() {
        int[] nums = {4, 2, 6, 8, 1};
        quickSortWithMiddlePivot(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSortWithMiddlePivot(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionWithMiddlePivot(nums, left, right);

            quickSortWithMiddlePivot(nums, left, pivotIndex - 1);
            quickSortWithMiddlePivot(nums, pivotIndex + 1, right);
        }
    }

    public static int partitionWithMiddlePivot(int[] nums, int left, int right) {

        // Move all smaller element on the left
        // Move all larger elements on the right
        // return the index of the partition which represent the element which is already at the right position

        int mid = left + (right - left) / 2;
        swap(nums, left, mid);

        int pivot = nums[left];

        int i = left;
        int j = left+1;

        while (j <= right) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
            j++;
        }

        swap(nums, left, i);
        int pivotIndex = i;
        return pivotIndex;
    }

    public static void validateQuestion1() {
        int[] nums = {10, 5, 3, 8};
        quickSort(nums, 0, nums.length - 1);
        System.out.println("Question 1: Sorted Array: " + Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }

        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {

        // Move all smaller element on the left
        // Move all larger elements on the right
        // return the index of the partition which represent the element which is already at the right position

        int pivot = nums[left];

        int i = left;
        int j = left+1;

        while (j <= right) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
            j++;
        }

        swap(nums, left, i);
        int pivotIndex = i;
        return pivotIndex;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
