package Week_3;
class Summation {
    public static void main(String[] args) {
        int result=sum(4,1);
        System.out.println(result);
    }
    public static int sum(int m,int n){
        if(n==1){
            return m*(m+1)/2;
        }else{
            return sum(sum(m,n-1), 1);
        }
       
    }
}
