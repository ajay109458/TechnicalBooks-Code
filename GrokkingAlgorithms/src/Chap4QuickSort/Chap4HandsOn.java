package Chap4QuickSort;

public class Chap4HandsOn {
    public static void main(String[] args) {

    }

    public static void validateQuestion1() {

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

        return left;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
