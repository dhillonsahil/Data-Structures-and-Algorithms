package Week_7.Assignment;

import java.util.Arrays;

public class Question3 {
    public static void main(String[] args) {
        int arr[] = {19,-20,7,-4,-13,11,-5,3};
        int[] temp=new int[arr.length];
        segerateRelative(arr,temp,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void segerateRelative(int arr[],int temp[],int start,int end){
        if(end<=start)return;
        // else
        int mid=start+(end-start)/2;
        segerateRelative(arr,temp,start, mid);
        segerateRelative(arr,temp, mid+1, end);

        // merge
        merge(arr, temp, start, mid, end);
    }
   public static void  merge(int[] arr,int[] temp ,int start,int mid,int end){
    int k = start;

    // negative of left
    for(int i=start;i<=mid;i++){
        if(arr[i]<0){
            temp[k++]=arr[i];
        }
    }
    // negATive of right

    for(int i=mid+1;i<=end;i++){
        if(arr[i]<0){
            temp[k++]=arr[i];
        }
    }

     // positive of left
    for(int i=start;i<=mid;i++){
        if(arr[i]>0){
            temp[k++]=arr[i];
        }
    }
    /// right positive
    for(int i=mid+1;i<=end;i++){
        if(arr[i]>=0){
            temp[k++]=arr[i];
        }
    }

    // copy to original
    for(int i=start;i<=end;i++){
        arr[i]=temp[i];
    }

    }
}
