package Week_3;
public class BinarySearch {
    public static void main(String[] args) {
        int []arr = {2,4,8,10,12};
        int target=10;
        System.out.println("Index is :"+binarySearch(arr, 0, arr.length-1, target));
    }
    public static int binarySearch(int arr[],int low,int high,int target){
        int mid = low + high-low/2;
        if(low>=high){
            return -1;
        }
        if(arr[mid]==target){
            return mid;
        }else{
            if(arr[mid]<target){
                return binarySearch(arr, mid+1, high, target);
            }else{
                return binarySearch(arr, low, mid-1, target);
            }
        }
    }
}
