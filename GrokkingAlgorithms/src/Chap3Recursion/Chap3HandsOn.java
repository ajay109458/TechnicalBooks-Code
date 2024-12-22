package Chap3Recursion;

public class Chap3HandsOn {
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

    }

    public static void validateQuestion9() {
        String word = "radar";
        boolean isPalindrome = isPalindrome(word, 0, word.length() -1);
        System.out.println("Question 9: Is Palindrome : " + isPalindrome);
    }

    public static boolean isPalindrome(String word, int left, int right) {
        if (left > right) {
            return true;
        }

        if (word.charAt(left) == word.charAt(right)) {
            return isPalindrome(word, left + 1, right-1);
        }

        return false;
    }

    public static void validateQuestion8 () {
        int[] nums = {3, 1, 4, 1, 5};
        System.out.println("Question 8: Max Elements: " + findMax(nums, 0));
    }

    public static int findMax(int[] nums, int index) {
        if (index == nums.length - 1) {
            return nums[index];
        }

        return Math.max(findMax(nums, index + 1), nums[index]);
    }

    public static void validateQuestion7() {
        int[] nums = {10, 20, 30, 40};
        int count = countElements(nums, 0);
        System.out.println("Question 7: " + count);
    }

    public static int countElements(int[] nums, int index) {
        if (index == nums.length) {
            return 0;
        }

        return 1 + countElements(nums, index + 1);
    }

    public static void validateQuestion6() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 5;
        int index = binarySearch(nums, 0, nums.length - 1, target);
        System.out.println("Question 6: Index in binary search: " + index);
    }

    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearch(nums, left, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, right, target);
        }
    }

    public static void validateQuestion5() {
        int value = power(2, 3);
        System.out.println("Question 5: Power of 2 to 3 is " + value);
    }

    public static int power(int num, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return num;
        }

        return num * power(num, n - 1);
    }

    public static void validateQuestion4() {
        String input = "hello";
        System.out.println("Question4: Reverse " + reverse(input) );
    }

    public static String reverse(String str) {
        if (str == null || str.length() == 0)
            return "";
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void validateQuestion3() {

        int[] nums = {2, 4, 6};
        int result = sumOfArray(nums, 0);
        System.out.println("Question 3: Sum of elements of array: " + result);
    }

    public static int sumOfArray(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        return nums[index] + sumOfArray(nums, index + 1);
    }

    public static void validateQuestion2() {
        System.out.println("Question 2: Fibonacci Series: ");
        fibonacci(0, 1, 10);
        System.out.println();
    }

    public static void fibonacci(int a, int b, int n) {
        if (n < 0) {
            return;
        }

        System.out.print(a + " ");
        fibonacci(b, a+b, n-1);
    }

    public static void validateQuestion1() {
        int n = 5;
        int result = factorial(n);
        System.out.println("Question 1: Factorial of " + n + " is " + result);
    }

    public static int factorial(int n) {
        // Base condition
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
