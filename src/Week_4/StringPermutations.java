package Week_4;
public class StringPermutations {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("For string " + str + " permutations are : ");
        permute(str, 0, str.length() - 1);
    }

    public static String swap(String str, int i, int j) {
        char[] cr = str.toCharArray();

        char temp = cr[i];
        cr[i] = cr[j];
        cr[j] = temp;

        return String.valueOf(cr);
    }

    public static void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);

                permute(str, l + 1, r);

                // backtracking
                str = swap(str, l, i);
            }
        }
    }
}
