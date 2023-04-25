package Week_2.Assignment;

import java.util.*;
public class InsertionSort_Desc {
    public static void main(String[] args) {
        int arr[] = {3,5,1,6,0};
        insertionSort(arr);
        System.out.println("Descending order of Arrat is"+Arrays.toString(arr));
    }
    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length-1;i++){
           int j=i;
           while(j>0 && arr[j]>arr[j-1]){
            int temp= arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            j--;
           }
        }
        
    }
}
