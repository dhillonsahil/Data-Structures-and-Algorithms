package Week_7.Assignment;

import java.util.Arrays;

public class Question1{
    public static void main(String[] args) {
        int arr[]={3,8,6,7,5,9,10};
        // int arr[]={3,6,5,7,8,9,10};
        mergeSort(arr,0,arr.length-1);
        System.out.println("Array now is "+Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int arr[],int l,int h){
        if(l<h){
            int m = l+(h-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, h);

            // merge Procesdure
            mergeProcedure(arr, l, m, h);

        }
    }
    public static void mergeProcedure(int arr[],int l , int m, int h){
        int lsubarr[]=Arrays.copyOfRange(arr, l, m+1);
        int rsubarr[]=Arrays.copyOfRange(arr,m+1,h+1);

        int i=0,j=0,k=l;

        while(i<lsubarr.length && j<rsubarr.length){
            if(lsubarr[i]<=rsubarr[j]){
                arr[k++]=lsubarr[i++];
            }else{
                arr[k++]=rsubarr[j++];
            }
        }
        while(i<lsubarr.length){
            arr[k++]=lsubarr[i++];
        }

        while(j<rsubarr.length){
            arr[k++]=rsubarr[j++];
        }
    }

}