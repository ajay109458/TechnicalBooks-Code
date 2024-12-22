package chapter1;

import java.util.Arrays;

public class Chap1HandsOn {
    public static void main(String[] args) {
        //validateQuestion1();
        //validateQuestion2();
        //validateQuestion3();
        //validateQuestion4();
        //validateQuestion5();
        //validateQuestion6();
        //validateQuestion7();
        //validateQuestion8();
        //validateQuestion9();
        validateQuestion10();
    }

    public static void validateQuestion10() {
        int[] num = {5, 9, 2, 4};
        int target = 9;

        int index = linearSearch(num, target);
        System.out.println("Index of " + target + " is " + index);
    }

    public static void validateQuestion9() {
        int[] nums = {1, 3, 5, 7};
        boolean isSorted = checkIfListIsSorted(nums);
        System.out.println(isSorted);
    }

    public static boolean checkIfListIsSorted(int[] nums) {
        boolean isIncreasing = true;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                isIncreasing = false;
            }
        }

        boolean isDecreasing = true;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                isDecreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }

    public static void validateQuestion8() {
        int[] nums = {1, 2, 4, 5};
        int missingNum = findMissingNumber(nums);
        System.out.println(missingNum);
    }

    public static int findMissingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int missingNumber = -1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid+1) {
                left = mid + 1;
            } else {
                missingNumber = mid+1;
                right = mid - 1;
            }
        }

        return missingNumber;
    }

    public static void validateQuestion7() {
        int[] nums = {1, 2, 3, 4};
        int[] result = reverse(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] reverse(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[nums.length - i - 1] = nums[i];
        }
        return result;
    }

    public static void validateQuestion6() {
        int[] nums = {1, 2, 3, 4, 5};
        int sum = sumOfElements(nums);
        System.out.println(sum);
    }

    public static int sumOfElements(int[] nums) {
        return Arrays.stream(nums)
                .sum();
    }

    public static void validateQuestion5() {
        int[] arr = {4, 5, 6, 5, 7, 5};
        int count = occurance(arr, 5);
        System.out.println("Occurance of 5 is : " + count);
    }

    public static int occurance(int[] arr, int target) {
        int count = 0;
        for(int num : arr) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    public static void validateQuestion4() {
        int[] arr = {23, 89, 12, 45, 67};
        int max = findMaximum(arr);
        System.out.println("Maximum number is : " + max);
    }

    public static Integer findMaximum(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void validateQuestion1() {
        int[] arr = {10, 23, 45, 70, 11, 15};
        int index = linearSearch(arr, 45);
        System.out.println("Index of 45 is : " + index);
    }

    public static void validateQuestion2() {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;

        int index = binarySearch(arr, target);
        System.out.println("Index of 30 is : " + index);
    }

    public static void validateQuestion3() {
        int[] arr = {3, 6, 8, 12, 14};
        int target = 8;

        int index = binarySearchRecursive(arr, 0, arr.length - 1, target);
        System.out.println("Index of 8 is : " + index);
    }

    public static int linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int left, int right, int num) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (arr[mid] == num) {
            return mid;
        } else if (arr[mid] < num) {
            return binarySearchRecursive(arr, left, mid - 1, num);
        } else {
            return binarySearchRecursive(arr, mid + 1, right, num);
        }
    }
}
