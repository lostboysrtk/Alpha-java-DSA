// Ques

import java.util.*;

public class Hashing7 {

    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String>revMap=new HashMap<>();

        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        for(String key: tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key; //starting poit
            }
        }
        return null;
    }
    public static void main (String args[]){

        /* //Count Distinct elements

        int num[]={4,3,2,5,6,7,3,5,4,2,1};

        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<num.length;i++){
            set.add(num[i]);
        }

        System.out.println(set.size());

        */


        /* 
        // Union n Intersection of 2 arrays
        
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};

        HashSet<Integer> set=new HashSet<>();

        //union
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }

        System.out.println(set.size());

        //intersection

        set.clear();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }

        int Count=0;
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                Count++;
                set.remove(arr2[i]);
            }
        }
        System.out.println(Count);

        */


        /* 
        // tickets

        HashMap<String, String>tickets=new HashMap<>();
        tickets.put("chennai", "benagalore");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");

        String start=getStart(tickets);

        System.out.print(start);

        for(String key: tickets.keySet()){
            System.out.print("->"+tickets.get(start));
            start=tickets.get(start);
        }

        */


        /* 
        //largest subarrays

        int arr[]={15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer>map=new HashMap<>();
        
        //(sum,idx)

        int sum=0;
        int len=0;

        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            if(map.containsKey(sum)){
                len=Math.max(len,i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        System.out.println(len);

        */


        // Subarrays sum equal to k
        
        int arr[]={10,2,-2,-20,10};
        int k=-10;

        HashMap<Integer,Integer>map=new HashMap<>();

        //(sum,count
        map.put(0, 1);

        int sum=0;
        int ans=0;

        for(int j=0;j<arr.length;j++){
            sum=sum+arr[j];
            if(map.containsKey(sum-k)){
                ans=ans+map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        System.out.println(ans);

    }
}
