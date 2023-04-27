package Week_2;

import java.util.*;
public class BubbleSort_Desc {
    public static void main(String[] args) {
        int[] arr={3,5,1,6,0};
        bubbleSort(arr);
        System.out.println("Descending order Of Array is : "+Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
