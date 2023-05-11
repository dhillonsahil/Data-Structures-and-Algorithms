package Week_1;

public class MissingNumber2 {
    public static void main(String[] args) {
        int arr[] ={1,2,3,5};
        System.out.println("MissingNumber number is "+ missing(arr, arr.length));
    }
    public static int missing(int[] arr , int n){
        int total =1;
        for(int i=2;i<=n+1;i++){
            total+=i;
            total-=arr[i-2];
        }return total;
    }
}
