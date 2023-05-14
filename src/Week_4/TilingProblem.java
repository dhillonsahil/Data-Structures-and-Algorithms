package Week_4;
public class TilingProblem{
    public static void main(String[] args) {
        int n=5;
        int ways =countWays(n);
        System.out.println("Total ways "+ways);
    }
    public static int countWays(int n){
        if(n<=3){
            return n;
        }
        return countWays(n-1) + countWays(n-2);
    }
}