package Week_2;

import java.util.Scanner;

public class IQ_LowerBound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array : ");
        int arrNo = sc.nextInt();

        // get array elements
        int arr[] = new int[arrNo];
        for (int i = 0; i < arrNo; i++) {
            arr[i] = sc.nextInt();
        }

        // get Number and search
        System.out.println("Enter element to Search : ");
        int x = sc.nextInt();
        int result = binarySearch(arr, x);
        if (result != -1) {
            System.out.println("Found at index : " + result);
        } else {
            System.out.println("Not found");
        }
        sc.close();
    }

    public static int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        int result=-1;
        while (low <= high) {
            // to avoid overflow
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result=mid;
                high=mid-1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            }
        }
        return result;
    }
}
