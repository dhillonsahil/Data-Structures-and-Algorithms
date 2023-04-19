package Week_1;
public class PrefixSumBrute {
    public static void main(String[] args){
        int arr[][]={
            {1,1,1,1},
            {1,1,1,1},
            {1,1,1,1},
            {1,1,1,1}
        };

        int r1=0;int c1=2; int r2=3;int c2=3;

        
        int sum=0;
        for(int i=r1;i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                sum+=arr[i][j];
            }
        }
        System.out.println(sum);
    }
}

// time complexity = O(m*n) where m = r2-r1 and n = c2-c1;
// space complexity = O(1)