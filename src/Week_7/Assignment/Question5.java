package Week_7.Assignment;

import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        int arr[][] = {
            {1,3},{5,7},{2,4},{6,8}
        };

        if (checkIntersect(arr, 0, arr.length - 1)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean checkIntersect(int[][] arr, int start, int end) {
        if (start == end) {
            return false; // Only one interval, no intersection
        }

        int mid = start + (end - start) / 2;
        boolean left = checkIntersect(arr, start, mid); // Check intersection in the left half
        boolean right = checkIntersect(arr, mid + 1, end); // Check intersection in the right half

        // Merge the results from the left and right halves
        if (left || right) {
            return true; // If intersection is found in either half, return true
        } else {
            return hasIntersection(arr[mid], arr[mid + 1]); // Check intersection between middle intervals
        }
    }

    public static boolean hasIntersection(int[] interval1, int[] interval2) {
        return interval1[1] >= interval2[0]; // Check if the end of the first interval is greater than or equal to the start of the second interval
    }
}

