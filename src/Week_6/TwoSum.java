package Week_6;
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int size= scan.nextInt();
        int nums[]=new int[size];
        System.out.println("Enter the array elements to inser to list : ");
        for(int i=0;i<size;i++){
            nums[i]=scan.nextInt();
        }

        // target
        System.out.println("Enter target : ");
        int target = scan.nextInt();

        // creating hashmap from arr:
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<size;i++){
            map.put(nums[i],i);
        }

        // checking 
        int result[]=new int[2];
        for(int i=0;i<size;i++){
            // case 1:
            if(nums[i]==target && map.containsKey(0)){
                result[0]=i;
                result[1]=map.get(0);
                break;
            }
            // 
            else if(map.containsKey(target-nums[i])){
                if(map.get(target-nums[i]) > i){
                    result[0]=i;
                    result[1]=map.get(target-nums[i]);
                }
                break;
            }
            // if(i==size-1){
            //     result[0]=-1;result[1]=-1;
            // }
        }
        scan.close();
        System.out.println(result[0] + " " +result[1]);
    }
}
