import java.util.*;

public class Hashing{
    public static void main(String args[]){

        //create
        HashMap<String,Integer>hm=new HashMap<>();

        //insert
        hm.put("India", 100);
        hm.put("China", 200);
        hm.put("USA", 50);
        hm.put("Nepal", 6);
        hm.put("Indonesia", 5);


        // System.out.println(hm);

        // //get 
        // int population=hm.get("India");
        // System.out.println(population);

        // //conatinsKey
        // System.out.println(hm.containsKey("India")); //true
        // System.out.println(hm.containsKey("UK")); //false

        // //remove
        // System.out.println(hm.remove("China"));
        // System.out.println(hm);

        // //size
        // System.out.println(hm.size());

        // //isempty
        // hm.clear();;
        // System.out.println(hm.isEmpty());


        //iterate or try from entryset()
        Set<String>keys=hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key="+k+",value="+hm.get(k));
        }

    }
}