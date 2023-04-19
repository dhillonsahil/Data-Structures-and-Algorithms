package Week_1;
public class Duplicate {
    public static void main(String[] args) {
        int arr[] = {2,4,4,5,7};
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    System.out.println(arr[j]);
                }
            }
        }
    }
}

// time Complexity O(n^2)
// space complexity O(1)