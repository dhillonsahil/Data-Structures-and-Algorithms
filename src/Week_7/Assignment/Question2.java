package Week_7.Assignment;

import java.util.Arrays;

public class Question2{
    public static void main(String[] args) {
        int arr[]={19,-20,7,-4,-13,11,-5,3};
        segrate(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int arr[], int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void segrate(int arr[],int i,int j){
        if(j<arr.length ){
            if(arr[j]<0){
                swap(arr, i, j);
                segrate(arr, i+1, j+1);
            }else{
                segrate(arr, i, j+1);
            }
        }
    }
}
