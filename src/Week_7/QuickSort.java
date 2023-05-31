package Week_7;
import java.util.*;
public class QuickSort{
    public static int partition(int arr[], int l, int h){
        int pivot = arr[l];
        int i=l;
        for(int j=i+1;j<=h;j++){
            if(arr[j]<=pivot){
                i=i+1;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        
        // swap pivot with i
         int temp=arr[l];
                arr[l]=arr[i];
                arr[i]=temp;

                return i;
    }
    public static void quickSort(int arr[], int l , int h){
        if(l<h){
            int m =partition(arr,l,h);
        quickSort(arr, l, m-1);
        quickSort(arr, m+1, h);
        }
    }
    public static void main(String[] args) {
        int arr[]={5,3,4,8,6,85,45,78,33,98};
        System.out.println("Array Before sorting is ");
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("Array After sorting is ");
        System.out.println(Arrays.toString(arr));
    }
}