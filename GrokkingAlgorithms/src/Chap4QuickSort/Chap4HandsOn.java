package Chap4QuickSort;

import java.util.Arrays;

public class Chap4HandsOn {
    public static void main(String[] args) {
        validateQuestion1();
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
