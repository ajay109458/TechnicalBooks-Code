package chapter2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Chapter2HandsOn {

    public static void main(String[] args) {
        //validateQuestion1();
        // validateQuestion2();
        // validateQuestion3();
        // validateQuestion4();
        // validateQuestion5();
        // validateQuestion6();
        // validateQuestion7();
        // validateQuestion8();
        validateQuestion10();
    }

    public static void validateQuestion1() {
        int[] nums = {29, 10, 14, 37, 13};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void validateQuestion2() {
        int[] nums = {8, 3, 7, 1, 9};
        int smallest = findSmallestElement(nums);
        System.out.println(smallest);

    }

    public static void validateQuestion3() {
        String[] arr = {"banana", "apple", "cherry", "date"};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void validateQuestion4() {
        int[] nums = {5, 2, 9, 3, 8};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void validateQuestion5() {
        int[] nums = {4, 3, 1, 2};
        int count = selectionSortSwapCount(nums);
        System.out.println("Swap count " + count);
    }

    public static void validateQuestion6() {
        float[] nums = {2.4F, 3.1F, 1.7F, 4.8F};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void validateQuestion7() {
        int[] nums = {7, 4, 2, 1};
        selectionSortStep(nums);
    }

    public static void validateQuestion8() {
        int[] nums = {9, 4, 7, 2, 6};
        int k = 3;
        selectionSortPartial(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void validateQuestion9() {
        //TODO
    }

    public static void validateQuestion10() {
        int[]  randomIntsArray = IntStream.generate(() -> new Random().nextInt(1000)).limit(1000).toArray();
        long startTime = System.nanoTime();
        selectionSort(randomIntsArray);
        long endTime = System.nanoTime();
        System.out.println("Time taken(ms): " + (endTime - startTime)/1000000);
    }

    public static void selectionSortDesc(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int maxIndex = indexOfMaxElement(nums, i);
            swap(nums, i, maxIndex);
        }
    }

    public static int selectionSortSwapCount(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int minIndex = indexOfMinElement(nums, i);

            if (i != minIndex) {
                swap(nums, i, minIndex);
                count++;
            }
        }
        return count;
    }

    public static void selectionSort(float[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int minIndex = indexOfMinElement(nums, i);
            swap(nums, i, minIndex);
        }
    }

    public static void selectionSortStep(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int minIndex = indexOfMinElement(nums, i);
            swap(nums, i, minIndex);
            System.out.println("Step " + (i+1) + " has values : " + Arrays.toString(nums));
        }
    }

    public static void selectionSortPartial(int[] nums, int k) {
        for(int i = 0; i < k; i++) {
            int minIndex = indexOfMinElement(nums, i);
            swap(nums, i, minIndex);
        }
    }

    public static void selectionSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            int minIndex = indexOfMinElement(nums, i);
            swap(nums, i, minIndex);
        }
    }

    public static void selectionSort(String[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = findSmallestIndex(arr, i);
            swap(arr, i, minIndex);
        }
    }

    public static void swap(float[] nums, int i, int j) {
        float temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void swap(String[] nums, int i, int j) {
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int indexOfMaxElement(int[] arr, int left) {
        int max = arr[left];
        int maxIndex = left;

        for(int i = left + 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static int indexOfMinElement(int[] arr, int left) {
        int min = arr[left];
        int minIndex = left;

        for(int i = left + 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static int indexOfMinElement(float[] nums, int left) {
        float min = nums[left];
        int minIndex = left;

        for(int i = left + 1; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static int findSmallestElement(int[] arr) {
        int min = arr[0];

        for(int num : arr) {
            if(num < min) {
                min = num;
            }
        }

        return min;
    }

    public static int findSmallestIndex(String[] arr, int left) {
        String min = arr[left];
        int minIndex = left;

        for(int i = left + 1; i < arr.length; i++) {
            if(arr[i].compareTo(min) < 0) {
                min = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
