package Week_1;

public class Array_4 {
    public static void main(String[] args){
        int arr[] = { 34, 21, 54, 65, 43 };
        int largest = Integer.MIN_VALUE;
        int SecondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                SecondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > SecondLargest && arr[i] != largest) {
                SecondLargest = arr[i];
            }
        }
        System.out.println(SecondLargest);
    }
}
