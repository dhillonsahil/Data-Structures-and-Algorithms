package Week_3;
import java.util.*;;
public class ArmStrongNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        int result=armStrong(n);
        if(result==n){
            System.out.println("The number is arm Strong");
        }else{
            System.out.println("The number is not arm strong");
        }
        sc.close();
    }
    public static int armStrong(int n){
        if(n<=0){
            return 0;
        }
        return (int)Math.pow(n%10, 3) + armStrong(n/10);
    }
}
