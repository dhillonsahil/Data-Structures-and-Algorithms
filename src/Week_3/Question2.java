package Week_3;

public class Question2 {
    public static void main(String[] args) {
        int n=10;
        int result=sumAlternateSign(n);
        System.out.println(result);
    }
    public static int sumAlternateSign(int n){
        if(n<=0 || n>1000000){
            return 0;
        }else {
            if(n%2==0){
                return  -n + sumAlternateSign(--n) ;
            }else{
                return n + sumAlternateSign(--n) ; 
            }
        }
    }
}
