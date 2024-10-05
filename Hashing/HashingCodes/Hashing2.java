// LinkedHashMao n TreeMap

import java.util.LinkedHashMap;

public class Hashing2 {
    public static void main(String args[]){
        //replace LinkedHashmap with TreeMap
        LinkedHashMap<String,Integer>lhm=new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 200);
        lhm.put("USA", 50);
        lhm.put("Nepal", 6);
        lhm.put("Indonesia", 5);

        System.out.println(lhm);
    }

}
