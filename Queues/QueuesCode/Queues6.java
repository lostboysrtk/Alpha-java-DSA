//Deque using JCF

import java.util.*;
import java.util.LinkedList;

public class Queues6 {
    public static void main(String args[]){
        Deque<Integer>deque=new LinkedList<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);

        System.out.println("first element="+deque.getFirst());
        System.out.println("Last element="+deque.getLast());
    }
    
}
