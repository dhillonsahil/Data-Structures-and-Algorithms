package Week_12;

public class FibonacciSeriesDP{
    public static void main(String[] args) {
        int n=5;
        System.out.println(fibNum(n));
    }

    // Approach 1 Bottom Up Approach using memoization
    public static int fibNum(int n){
        int f1=0;
        int f2=1;
        int c=0;
        for(int i=2;i<=n;i++){
            c=f1+f2;
            f1=f2;
            f2=c;
        }

        return f2;
    }

    // approach 2 Top Down approach using tabulation
    public static int fibboNum(int n){
        int arr[]= new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        return fibHelper(n ,arr);
    }

    // approach 2 helper
    static int fibHelper(int n , int arr[]){
        if(n==0 || n==1){
            return n;
        }

        if(arr[n]!=-1){
            return arr[n];
        }else{
            int x= fibHelper(n-1, arr);
            int y=fibHelper(n-2, arr);
            arr[n]=x+y;
            return arr[n];
        }
    }
}