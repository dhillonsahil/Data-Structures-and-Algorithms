package Week_2.Assignment;
import java.util.*;
public class SelectionSort_Desc {
    public static void main(String[] args) {
        int arr[]={3,5,1,6,0};
        selectionSort(arr);
        System.out.println("Descending Order is : " + Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int mid_idx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[mid_idx]<arr[j]){
                    mid_idx=j;
                }
            }
            if(mid_idx!=i){
                int temp= arr[mid_idx];
                arr[mid_idx]=arr[i];
                arr[i]=temp;
            }
        }
    }
}
