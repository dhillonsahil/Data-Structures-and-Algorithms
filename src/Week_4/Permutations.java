package Week_4;
public class Permutations {
    public static void main(String[] args) {
        String s = "ABC";
        doPermutations(s, 0, s.length()-1);
    }

    public static void doPermutations(String s, int l, int r) {
        // base case
        if (l == r) {
            System.out.println(s);
            return;
        }
        // recursive call
        for(int i=l;i<=r;i++){
            s=swap(s, i, l);
            doPermutations(s, l+1, r);
            s=swap(s, i, l);
        }
    }

    public static String swap(String s , int cur, int l){
        char arr[]=s.toCharArray();
        char temp = arr[cur];
        arr[cur]=arr[l];
        arr[l]=temp;

        return String.valueOf(arr);
    }
}
