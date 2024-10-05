import java.util.* ;  //ArrayList
public class Stacks {
    
    //static class Stack{

        /* 
        static ArrayList<Integer>list=new ArrayList<>();
        
        public static boolean isEmpty(){
            return list.size()==0;
        }

        //push
        public static void push(int data){
            list.add(data);
        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
        */

        /* 
        static class Node{
            int data;
            Node next;
            Node(int data){
                this.data=data;
                this.next=null;
            }
        }

        static class Stack{
            static Node head=null;

            public static boolean isEmpty(){
                return head==null;
            }

            //push
            public static void push(int data){
                Node newNode= new Node(data);
                if(isEmpty()){
                    head=newNode;
                    return;
                }
                newNode.next=head;
                head=newNode;
            }

            //pop
            public static int pop(){
                if(isEmpty()){
                    return -1;
                }
                int top=head.data;
                head=head.next;
                return -1;
            }

            //peek
            public static int peek(){
                if(isEmpty()){
                    return -1;
                }
                return head.data;
            }
        }
        */

        public static void pushAtBottom(Stack<Integer>s,int data){
            if(s.isEmpty()){
                s.push(data);
                return;
            }
            int top=s.pop();
            pushAtBottom(s, data);
            s.push(top);
        }

        public static String reverseString(String str){ 
            Stack<Character>s=new Stack<>();
            int idx=0;
            while(idx<str.length()){
                s.push(str.charAt(idx));
                idx++;
            } 
            StringBuilder result=new StringBuilder("");
            while (!s.isEmpty()){
                char curr=s.pop();
                result.append(curr);
            }
            return result.toString();
        }

        public static void reverseStack(Stack<Integer>s){
            if(s.isEmpty()){
                return;
            }
            int top=s.pop();
            reverseStack(s);
            pushAtBottom(s, top);
        }

        public static void printStack(Stack<Integer>s){
            while(!s.isEmpty()){
                System.out.println(s.pop());
            }
        }

        public static void stockSpan(int stocks[],int span[]){
            Stack<Integer>s=new Stack<>();
            span[0]=1;
            s.push(0);

            for(int i=1;i<stocks.length;i++){
                int currPrice=stocks[i];
                while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                    s.pop();
                }
                if(s.isEmpty()){
                    span[i]=i+1;
                }else{
                    int prevHigh=s.peek();
                    span[i]=i-prevHigh;
                }
                s.push(i);
            }
        }

        public static boolean isValid(String str){
            Stack<Character>s=new Stack<>();
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(ch=='(' || ch=='[' || ch=='{'){//opening
                    s.push(ch);
                }else{
                    //closing
                    if(s.isEmpty()){
                        return false;
                    }
                    if( (s.peek()=='(' && ch==')') || 
                    (s.peek()=='{' && ch=='}') ||
                    (s.peek()=='[' && ch==']') ){
                        s.pop();
                    }else{
                        return false;
                    }
                }
            }
            if(s.isEmpty()){
                return true;
            }else{
                return false;
            }
        }

        public static boolean isDuplicate(String str){
            Stack<Character>s=new Stack<>();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);

                //closing
                if(ch==')'){
                    int count =0;
                    while(s.peek()!='('){
                        s.pop();
                        count++;
                    }
                    if(count<1){
                        return true; //duplicate
                    }else{
                        s.pop(); //opening pair
                    }
                }else{
                    //opening
                    s.push(ch);
                }
            }
            return false;
        }

        public static void maxArea(int arr[]){
            int maxArea=0;
            int nsr[]=new int [arr.length];
            int nsl[]=new int [arr.length];

            //Next smaller Right
            Stack<Integer>s=new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){ //chnge < replace by >
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        //Next Smaller Left

        for(int i=0;i<arr.length;i++){ //change inside for
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=-1; // change
            }else{
                nsl[i]=s.peek(); //change
            }
            s.push(i);
        }

        //curr area: width=j-i-1=nsr[i]-nsl[i]-1
        for(int i=0;i<arr.length;i++){
            int height = arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            maxArea=Math.max(currArea,maxArea);
        }
        System.out.println("max area of histogram="+ maxArea);
    }



    public static void main(String args[]){

        
        //Stack s=new Stack();
        Stack<Integer>s=new Stack<>();

        // s.push(1);
        // s.push(2);
        // s.push(3);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // pushAtBottom(s,4);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        // String str = "abc";
        // String result=reverseString(str);
        // System.out.println(result);


        // s.push(1);
        // s.push(2);
        // s.push(3);
        // reverseStack(s);
        // printStack(s);


        // int stocks[]={100,80,60,70,60,85,100};
        // int span[]=new int[stocks.length];
        // stockSpan(stocks, span);
        // for(int i=0;i<span.length;i++){
        //     System.out.println(span[i]+" ");
        // }


        // int arr[]={6,8,0,1,3};
        // int nxtGreater[]=new int[arr.length];
        // for(int i=arr.length-1;i>=0;i--){
        //     while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
        //         s.pop();
        //     }
        //     if(s.isEmpty()){
        //         nxtGreater[i]=-1;
        //     }else{
        //         nxtGreater[i]=arr[s.peek()];
        //     }
        //     s.push(i);
        // }
        // for(int i=0;i<nxtGreater.length;i++){
        //     System.out.print(nxtGreater[i]+" ");
        // }
        // System.out.println();


        // String str="({})[]";
        // System.out.println(isValid(str));


        // String str="((a+b))"; //true
        // String str2="(a-b)";//false
        // System.out.println(isDuplicate(str2));


        // int arr[]={2,1,5,6,2,3}; //hieghts in histogram
        // maxArea(arr);


    }
}


