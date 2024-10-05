//Activity Selection

import java.util.*;

public class GreedyAlgo{
    public static void main(String args[]){
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

        //sorting end
        int activities[][]=new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }

        //lambda function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        //end time basis sorted
        int maxAct=0;
        ArrayList<Integer> ans=new ArrayList<>();

        //1st Activity
        maxAct=1;
        ans.add(activities[0][0]);      //ans.add(0);
        int lastEnd=activities[0][2];        //end[0];
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>=lastEnd){      //(start[i]>=lastEnd){
                ///activity select
                maxAct++;
                ans.add(activities[i][0]);    //ans.add(i);
                lastEnd=activities[i][2];   //lastEnd=end[i];
            }
        }
        System.out.println("max activities="+maxAct);
        for(int i=0; i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }

}
