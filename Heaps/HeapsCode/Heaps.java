import java.util.PriorityQueue;
import java.util.*;

public class Heaps{

    /* 
    static class Student implements Comparable<Student>{  //overriding
        String name;
        int rank;

        public Student(String name, int rank){
            this.name=name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }
    */

    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data){
        //add at last idx
        arr.add(data);

        int x=arr.size()-1;//x is child idx
        int par=(x-1)/2; // parent idx

        while(arr.get(x)<arr.get(par)){ //O(logn)
            //swap
            int temp=arr.get(x);
            arr.set(x,arr.get(par));
            arr.set(par,temp);

            x=par;
            par=(x-1)/2;
        }
    }

    public int peek(){
        return arr.get(0);
    }

    private void heapify(int i){
        int left=2*i+1;
        int right=2*i+2;
        int minIdx=i;

        if(left<arr.size() && arr.get(minIdx) > arr.get(left)){
            minIdx=left;
        }
        if(right<arr.size() && arr.get(minIdx) > arr.get(right)){
            minIdx=right;
        }

        if(minIdx!=i){
            //swap
            int temp=arr.get(i);
            arr.set(i, arr.get(minIdx));
            arr.set(minIdx, temp);

            heapify(minIdx);
        }
    }

    public int remove(){
        int data=arr.get(0);
        
        //step1 swap
        int temp=arr.get(0);
        arr.set(0, arr.get(arr.size()-1));
        arr.set(arr.size()-1, temp);

        //step2 delete
        arr.remove(arr.size()-1);

        //step 3 heapify
        heapify(0);
        return data;
    }

    public boolean isEmpty(){
        return arr.size()==0;
    }

    public static void heapify2(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;

        if(left<size && arr[left] > arr[maxIdx]){
            maxIdx=left;
        }
        if(right<size && arr[right] > arr[maxIdx]){
            maxIdx=right;
        }

        if(maxIdx!=i){
            //swap
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;

            heapify2(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]){
        //step1
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify2(arr,i,n);
        }

        //step2
        for(int i=n-1;i>0;i--){
            //swap largest first
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify2(arr,0,i);

        }
    }

    public static void main(String args[]){

        /* 
        PriorityQueue<Student>pq=new PriorityQueue<>();

        pq.add(new Student("a",4));
        pq.add(new Student("b",5));
        pq.add(new Student("c",2));
        pq.add(new Student("d",12));
        while(!pq.isEmpty()){  //heap sort
            System.out.println(pq.peek().name+"->"+ pq.peek().rank);
            pq.remove();
        }
        */

        // Heaps h= new Heaps();
        // h.add(3);
        // h.add(4);
        // h.add(1);
        // h.add(5);

        // while(!h.isEmpty()){
        //     System.out.println(h.peek());
        //     h.remove();
        // }

        int arr[]={1,2,4,5,3};

        heapSort(arr);

        //print
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
}