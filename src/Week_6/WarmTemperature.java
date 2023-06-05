package Week_6;
import java.util.*;
public class WarmTemperature {
    public static void main(String[] args) {
        int temp[]={73,74,75,71,69,72,76,73};
        int result[]=temps(temp);
        for(int i:result){
            System.out.print(i + ",");
            System.out.println();
        }
    }
    public static int[] temps(int[] temp){
        Stack<Integer> st = new Stack<>();
        int []nge = new int[temp.length];
        for(int i=0;i<temp.length;i++)nge[i]=0;
        
        for(int i=nge.length-1;i>=0;i--){
            while(!st.isEmpty() && temp[st.peek()]<=temp[i])st.pop();

            if(!st.isEmpty()){
                nge[i]= st.peek()-i;
            }
            st.push(i);
        }
        return nge;
    }
}
