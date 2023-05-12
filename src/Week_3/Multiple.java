package Week_3;
public class Multiple{
    public static void main(String[] args) {
        int a=4;
        int b=500;
        printMultiple(a, b);
    }
    public static void printMultiple(int a,int b){
        if(b==1){
            System.out.println(a);
            return;
        }
        printMultiple(a, b-1);
        System.out.println(a*b);
    }
}