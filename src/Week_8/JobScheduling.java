package Week_8;

import java.util.*;

public class JobScheduling {
    int deadline,profit;
    char jobId;
    JobScheduling(){}
    JobScheduling(int deadline,int profit,char jobId){
        this.deadline=deadline;
        this.jobId=jobId;
        this.profit=profit;
    }
    public static void main(String[] args) {
        ArrayList<JobScheduling> arr= new ArrayList<>();
        arr.add(new JobScheduling(5, 55, '1'));
        arr.add(new JobScheduling(2,65,'2'));
        arr.add(new JobScheduling(7,75,'3'));
        arr.add(new JobScheduling(3,60,'4'));
        arr.add(new JobScheduling(2,70,'5'));
        arr.add(new JobScheduling(1,50,'6'));
        arr.add(new JobScheduling(4,85,'7'));
        arr.add(new JobScheduling(5,68,'8'));
        arr.add(new JobScheduling(3,45,'9'));
        JobScheduling job = new JobScheduling();
        job.printSchedule(arr,7);
    }
    public void printSchedule(ArrayList<JobScheduling> arr,int maxDeadline){
        // 1. Sort according to profit
        Collections.sort(arr,(a,b)-> b.profit-a.profit);
        // create job id and result
        boolean []result=new boolean[arr.size()];
        // for(int i=0;i<maxDeadline;i++)result[i]=false;
        char jobid[]=new char[maxDeadline];

        // adding minimum of maxdeadline -1 or arr.get(i).deadline
        for(int i=0;i<arr.size();i++){
            for(int j=Math.min(maxDeadline-1, arr.get(i).deadline-1);j>=0;j--){
                if(result[j]==false){
                    result[j]=true;
                    jobid[j]=arr.get(i).jobId;
                    break;
                }
            }
        }

        // print
        System.out.println(Arrays.toString(jobid));

        return;
    }
}

// o(n^2)
// space O(n)