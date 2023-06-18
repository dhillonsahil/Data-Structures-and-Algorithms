package Week_8;

import java.util.Arrays;
import java.util.Comparator;

public class Fractionalknabsack{
    static class ItemValue{
        int weight,profit;
        ItemValue(int p , int w){
            this.weight=w;
            this.profit=p;
        }
    }
    public static void main(String[] args) {
        ItemValue[] arr={
            new ItemValue(25, 5),
            new ItemValue(75, 10),
            new ItemValue(100,12),
            new ItemValue(50,4),
            new ItemValue(45,7),
            new ItemValue(90,9),
            new ItemValue(30,3),
        };

        double max= getMaxVal(arr,37);
        System.out.println(max);
    }
    public static double getMaxVal(ItemValue arr[],int capaticy){

        // sorting according to p/w
        Arrays.sort(arr,new Comparator<ItemValue>() {
          @Override
        public int compare(ItemValue item1, ItemValue item2){
            double cpr1 = Double.valueOf(item1.profit/item1.weight);
            double cpr2 = Double.valueOf(item2.profit/item2.weight);
            if(cpr1<cpr2){
                return 1;
            }else{
                return -1;
            }
        }
      });

      // adding profit reducing weight
      double totalvalue=0;
      for(ItemValue i:arr){
        int currentCap = (int)i.weight;
        int curProfit =(int)i.profit;
        if(capaticy-currentCap>=0){
            totalvalue+=curProfit;
            capaticy-=currentCap;
        }else{
            double fraction = ((double)capaticy/(double)currentCap);
            totalvalue+= (curProfit * fraction);
            capaticy=(int)(capaticy-(currentCap*fraction));
            break;
        }
      }
        // to be changed
        return totalvalue;
    }
    
}

// time :- nlogn
// space :- 1