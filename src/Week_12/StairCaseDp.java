package Week_12;

public class StairCaseDp {
    public static void main(String[] args) {
        System.out.println(stairCount(4));
    }
    public static int stairCount(int n){
        if(n<=3)return n;
        int arr[]=new int[n];
        arr[0]=1;
        arr[1]=2;
        
        for(int i=2;i<n;i++){
            arr[i]=arr[i-2] + arr[i-1];
        }

        return arr[n-1];
    }
}
