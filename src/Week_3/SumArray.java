package Week_3;

public class SumArray {
    public static void main(String[] args){
        int []arr={1,2,3,4};
        int result= sumOfArray(arr,0);
        System.out.println(result);
    }
    public static int sumOfArray(int arr[],int a){
        if(a==arr.length-1){
            return arr[a];
        }
        return arr[a]+sumOfArray(arr, ++a);
    }
}