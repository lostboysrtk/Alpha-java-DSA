//import java.util.LinkedList;
public class LinkedList{
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //methods

    public void addFirst(int data){
        //step1- create new node
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        //step2- newNode next=head
        newNode.next=head;//link

        //step3- head=newNode
        head=newNode;
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void print(){
        if(head==null){
            System.out.println("ll is empty");
            return;
        }

        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void addM(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode= new Node(data);
        size++;
        Node temp= head;
        int i=0;

        while(i<idx-1){
            temp=temp.next;
            i++;
        }

        //i=idx-1;temp->prev
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public int removieFirst(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.print("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        //prev: i=size-2
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }

        int val=prev.next.data; //or tail.data
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp=head;
        int i=0;

        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;      //not found
    }

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx =helper(head.next, key);
        if(idx==-1){
            return -1;
        }
        return idx +1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public void deleteNthfromEnd(int n){
        //calc size
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        
        if(n==sz){
            head=head.next;//remove first
            return;
        }

        //sz-n
        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }

    //slow-fast approach
    public Node findmid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow; // slow is mid Node now
    }

    public boolean checkPalindrome(){
        if(head==null|| head.next==null){
            return true;
        }

        //step1 - find mid
        Node midNode=findmid(head);

        //step2- reverse from mid
        Node prev=null;
        Node curr=midNode; //only chnge 
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev; //ryt half head
        Node left=head;
    
        //step3- check lft n ryt
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next !=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if(slow==fast){
                return true; //cycle exists
            }
        }
        return false;//cycle doesnt exist
    }

    public static void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;

        while(fast!=null && fast.next !=null){
            slow=slow.next;//+1
            fast=fast.next.next;//+2
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        //find meeting point
        slow=head;
        Node prev=null;//last node
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }

        //remove cycle -> last.next=null
        prev.next=null;
    }


    //linkedList2
    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;//mid node
    }

    private Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;

        while(head!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }

        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }

        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head==null||head.next==null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //lft n ryt ms
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);
    }

    public void ZigZag(){
        //step1 find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        //reverse step2
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node left=head;
        Node right=prev;
        Node nextL,nextR;

        //alt merge zig zag
        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }

    }



    public static void main(String args[]){
        
        
        LinkedList ll= new LinkedList();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.addLast(5);
        ll.print();
        
        ll.addM(2,3 );
        ll.print();
        System.out.println("size:"+ll.size);

        ll.removieFirst();
        ll.print();
        ll.removeLast();
        ll.print();

        System.out.println(ll.itrSearch(3));
        System.out.println(ll.recSearch(3));

        ll.reverse();
        ll.print();

        
        /* 
        ll.deleteNthfromEnd(2);
        ll.print();


        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        System.out.println(ll.checkPalindrome());

        */


        // head=new Node(1);
        // Node temp=new Node(2);
        // head.next=temp;
        // head.next.next=new Node(3);
        // head.next.next.next=temp;
        // System.out.println(isCycle());

        // removeCycle();
        // System.out.println(isCycle());



        /* 
        //create
        LinkedList<Integer>ll=new LinkedList<>();

        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);

        System.out.println(ll);

        //remove
        ll.removeFirst();
        ll.removeLast();

        System.out.println(ll);
        */


        // LinkedList ll= new LinkedList();
        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);

        // ll.print();
        // ll.head=ll.mergeSort(ll.head);
        // ll.print();/


        // LinkedList ll= new LinkedList();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        
        // ll.print();
        // ll.ZigZag();
        // ll.print();

    
    }
}
