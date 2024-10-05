//iteration on hashset n LinkedHashSet n TreeSet

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Hashing6 {
    public static void main(String args[]){
        HashSet<String>cities=new HashSet<>();

        cities.add("delhi");
        cities.add("mumbai");
        cities.add("noida");
        cities.add("gurugram");

        // Iterator it=cities.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }

        // for (String city : cities) {
        //     System.out.println(city);
        // }


        // LinkedHashSet<String>lhs=new LinkedHashSet<>();
        // lhs.add("delhi");
        // lhs.add("mumbai");
        // lhs.add("noida");
        // lhs.add("gurugram");

        // System.out.println(lhs);


        TreeSet<String>ts=new TreeSet<>();
        
        ts.add("delhi");
        ts.add("mumbai");
        ts.add("noida");
        ts.add("gurugram");

        System.out.println(ts);




    }
}
