package Week_7;

import java.util.*;

public class Merge_Sort {
    public static void mergeSort(int arr[], int l, int h){
        if(l<h){
            // 1. Divide
            int m=l +(h-l)/2;
            // 2. conquer
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, h);

            // 3. merge
            mergeProcedure(arr, l, m, h);
        }
    }
    public static void mergeProcedure(int arr[], int l , int mid, int h){
        int i,j,k;
        // left sub arr size
        int n1 = mid -l +1;
        // right sub arr size
        int n2 = h-mid;

        // copy elements in sub arrays
        int lsubarray[]=Arrays.copyOfRange(arr, l, mid+1);
        int rsubarray[]=Arrays.copyOfRange(arr, mid+1, h+1);

        i=0;
        k=l;
        j=0;
        
        // comparing and adding values
        while(i<n1 && j<n2){
            if(lsubarray[i]<=rsubarray[j]){
                arr[k++]=lsubarray[i++];
            }else{
                arr[k++]=rsubarray[j++];
            }
        }

        while(i<n1){
            arr[k++]=lsubarray[i++];
        }
        while(j<n2){
            arr[k++]=rsubarray[j++];
        }

        }
    public static void main(String[] args) {
        int arr[] = {4,3,1,78,65,45,90};
        System.out.println("Array before sorting is \n"+Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println("Array after sorting is \n"+Arrays.toString(arr));
    }
}
