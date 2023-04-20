package Week_1;

public class Array_5 {
    public static void main(String[] args){
        int arr[] ={1,4,7,3,2,6,5};
        
        for(int i=0;i<arr.length-2;i++){
            if(arr[i+1]<arr[i] && arr[i-1]<arr[i]){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
