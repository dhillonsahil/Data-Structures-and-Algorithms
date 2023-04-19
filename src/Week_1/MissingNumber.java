package Week_1;

public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {1,2,4,7,6,5};
        int sum=0;
        for(int a:arr){
            sum+=a;
        }
        int missingNumber=((arr.length+1)*(arr.length+2))/2 -sum;
        System.out.println("Missing Number is : "+missingNumber);
    }
}
