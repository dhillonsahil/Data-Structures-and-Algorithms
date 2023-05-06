package Week_3;
public class Max {
    public static void main(String[] args) {
        int arr[] = {13,1,-3,22,5};
        int result = findMax(arr);
        System.out.println(result);
    }
    public static int findMax(int arr[]){
        return checkMax(arr, 0);
    }
    public static int checkMax(int arr[],int i){
        if(i==arr.length-1){
            return arr[i];
        }
        int Max=checkMax(arr,i+1);
        return arr[i]>Max?arr[i]:Max;
    }

    // public static int findMax(int arr[]){
    //     return checkMax(arr, 0, Integer.MIN_VALUE);
    // }

    // public static int checkMax(int arr[], int i,int max){
    //     if(i==arr.length){
    //         return max;
    //     }
    //     if(arr[i]>max){
    //         max=arr[i];
    //     }
    //     return checkMax(arr, i+1, max);
    // }
}
