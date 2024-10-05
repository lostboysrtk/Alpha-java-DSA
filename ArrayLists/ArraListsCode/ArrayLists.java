import java.lang.reflect.Array;
import java.util.*;
public class ArrayLists {

    public static void swap(ArrayList<Integer>list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }

    public static int storeWater(ArrayList<Integer>height){
        int maxWater=0;
        //brute force
        for(int i=0;i<height.size();i++){
            for(int j=0;j<height.size();j++){
                int ht=Math.min(height.get(i),height.get(j));
                int width=j-i;
                int currWater=ht*width;
                maxWater=Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }

    public static int optStoreWater(ArrayList<Integer>height){
        int maxWater=0;
        int lp=0;
        int rp=height.size()-1;

        while(lp<rp){
            //calc water area
            int ht=Math.min(height.get(lp),height.get(rp));
            int width=rp-lp;
            int currWater=ht*width;
            maxWater=Math.max(maxWater,currWater);

            //update ptr
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }    
        }
    return maxWater;
    }


    public static boolean pairSum(ArrayList<Integer>list,int target){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum1(ArrayList<Integer>list,int target){
        int lp=0;
        int rp=list.size()-1;
        
        while(lp!=rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            if(list.get(lp)+list.get(rp)<target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }


    public static boolean pairSum2(ArrayList<Integer>list,int target){
        int bp=-1;
        int n=list.size();
        for(int i=0;i<list.size();i++){
            if(list.get(i)>list.get(i+1)){//breaking point
                bp=i;
                break;
            }
        }
        int lp=bp+1;//smallest
        int rp=bp;//largest

        while(lp!=rp){
            //cae1
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            //case2
            if(list.get(lp)+list.get(rp)<target){
                lp=(lp+1)%n;
            }else{
                //case3
                rp=(n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String args[]){

        /* 
        ArrayList<Integer>list=new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);
        */

        // //reverse print
        // for(int i=list.size()-1;i>=0;i--){
        //     System.out.print(list.get(i)+" ");
        // }
        // System.out.println();

        /* 
        //maxi
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(max<list.get(i)){
                max=list.get(i);
            }
        }
        

        //or intead of if
        //max=Math.max(max,list.get(i));

        System.out.println("maxi element="+max);
        */

        /* 
        int idx1=1,idx2=3;
        swap(list, idx1, idx2); 
        System.out.print(list);
        */


        /* 
        ArrayList<ArrayList<Integer>>mainList=new ArrayList<>();
        
        ArrayList<Integer>list=new ArrayList<>();
        list.add(1); list.add(2);
         
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(3);list2.add(4);

        mainList.add(list);
        mainList.add(list2);

        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer>currlist=mainList.get(i);
            for(int j=0;j<currlist.size();j++){
                System.out.print(currlist.get(j));
            }
            System.out.println();
        }
        System.out.println(mainList);

        */


        /* 
        ArrayList<ArrayList<Integer>>mainlist=new ArrayList<>();

        ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();
        ArrayList<Integer>list3=new ArrayList<>();

        for(int i=1;i<=5;i++){
            list1.add(i*1);//12345
            list2.add(i*2);//2468
            list3.add(i*3);//369
        }

        mainlist.add(list1);
        mainlist.add(list3);
        mainlist.add(list2);

        System.out.println(mainlist);

        //nested loops
        for(int i=0;i<mainlist.size();i++){
            ArrayList<Integer>currList=mainlist.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
        */

        //container most water

        /*
        ArrayList<Integer>height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        */
        
        // System.out.print(storeWater(height));

        //System.out.print(optStoreWater(height));

        //System.out.println(pairSum(height,5));

        /* 
        ArrayList<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.print(pairSum1(list, 5));
        */

        ArrayList<Integer>list=new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.print(pairSum2(list, 16));




    }
}
