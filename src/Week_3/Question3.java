// Question 4

package Week_3;

public class Question3 {
    public static void main(String[] args){
        int []arr={1,2,3,4};
        int result= maxInArr(arr,0);
        System.out.println(result);
    }
    public static int maxInArr(int arr[],int a){
        if(a==arr.length-1){
            return arr[a];
        }
        return arr[a]+maxInArr(arr, ++a);
    }
}
