package Week_7.Assignment;
public class Question4 {
    public static void main(String[] args) {
            int a[]={2,1,3};
            int b[]={7,8,9};
            int k=10;
            checkPerms(a, b, 0, k);
      
    }
    public static void checkPerms(int a[], int b[], int i, int k){
        if(i<a.length){
            if(a[i]+b[i]>=k){
                System.out.println("Yes");
                System.exit(0);
            }else{
                checkPerms(a, b, i+1, k);
            }
        }else{
            System.out.println("No");
        }
    }
}
