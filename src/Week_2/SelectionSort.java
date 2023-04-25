package Week_2;
import java.util.*;
public class SelectionSort {
    public static void main(String[] args) {
        int arr[]={20,50,10,15,17,25,65};
        selectionSort(arr);
        System.out.println("Sorted Array is : "+Arrays.toString(arr));
    }
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            // min idx is taking the index of minium element at every iteration
            int min_idx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min_idx]){
                    min_idx=j;
                }
            }
            if(min_idx==i){
                int temp=arr[i];
            arr[i]=arr[min_idx];
            arr[min_idx]=temp;
            }
        }
    }
}
