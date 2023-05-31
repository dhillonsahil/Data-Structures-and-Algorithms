package Week_7;

import java.util.Arrays;

public class CountInveersion {

    // count inversion using merge sort
    public static int inversionCount(int arr[],int l,int r){
        int count = 0;
       if(l<r){
        // 1. divide
        int mid = l+(r-l)/2;
        count+= inversionCount(arr, l, mid);
        count +=inversionCount(arr, mid+1, r);

        count += mergeSort(arr, l , mid , r);
    }
    return count;
    }

    // merge procedure
    public static int mergeSort(int arr[], int l , int mid , int r){
        int swap = 0;
        int i=0,j=0,k=l;
        int lsubarr[]= Arrays.copyOfRange(arr, l, mid+1);
        int rsubarr[]= Arrays.copyOfRange(arr, mid+1, r+1);


        while(i<lsubarr.length && j<rsubarr.length){
            if(lsubarr[i]<=rsubarr[j]){
                arr[k++]=lsubarr[i++];
            }else{
                arr[k++]=rsubarr[j++];
                swap+=(mid+1)-(l+i);
            }
        }
        while(i<lsubarr.length){
            arr[k++]=lsubarr[i++];
        }

        while(j<rsubarr.length){
            arr[k++]=rsubarr[j++];
        }
        return swap;
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        int count= bruteforceCount(arr);
        System.out.println("inversion count is "+count);
        int countInv = inversionCount(arr, 0, arr.length-1);
        System.out.println("inversion count is "+countInv);
    }

    // brute force method to count
    public static int bruteforceCount(int arr[]){
        int count =0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count+=1;
                }
            }
        }

        return count;
    }
}
