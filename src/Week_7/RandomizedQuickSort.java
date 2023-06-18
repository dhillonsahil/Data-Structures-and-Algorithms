package Week_7;

import java.util.Arrays;

public class RandomizedQuickSort {
    public static void main(String[] args) {
        int arr[]={1,3,2,4,5,6,7};
        int n = arr.length;
        quickSortAlgo(arr, 0, n-1);
        System.out.println(arr[n-2]);

    }
    public static void quickSortAlgo(int[] arr,int l, int h){
        if(l<h){
            int m =partition(arr,l,h);

        quickSortAlgo(arr, l, m-1);
        quickSortAlgo(arr, m+1,h);
        }
    }
    public static int partition(int arr[], int l ,int h){
        int randomIndex = l + (int)(Math.random() % (h - l + 1));
        int temp = arr[randomIndex];
        arr[randomIndex]=arr[l];
        arr[l]=temp;

        int pivot = arr[l];
        int i=l;
        for(int j=l+1;j<=h;j++){
            if(arr[j]<=pivot){
                i = i+1;
                int tem = arr[i];
                arr[i]=arr[j];
                arr[j]=tem;
            }
        }

        int tem =arr[l];
        arr[l]=arr[i];
        arr[i]=tem;

        return i;
    }
}