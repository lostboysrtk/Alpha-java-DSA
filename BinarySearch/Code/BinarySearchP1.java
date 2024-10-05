//BST p1 +P2

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinarySearchP1{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root, int val){
        if(root==null){
            root=new Node (val);
            return root;
        }
        if(root.data>val){
            //lft subtree
            root.left=insert(root.left,val);
        }
        else{
            //ryt subtree 
            root.right=insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }

        if(root.data==key){
            return true;
        }

        if(root.data>key){
            return search(root.left, key);
        }

        else{
            return true;
        }
    }

    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right=delete(root.right, val);
        }else if(root.data>val){
            root.left=delete(root.left, val);
        }else{
            //case1
            if(root.left==null && root.right==null){
                return null;
            }
            //case2
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            //case3
            Node IS=findInOrderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInOrderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }   
    }

    public static void printPath(ArrayList<Integer>path){
        for(int i=0;i<path.size(); i++){
            System.out.print(path.get(i)+ "->");
        }
        System.out.println("null");
    }

    public static void printRootToLeaf(Node root,ArrayList<Integer>path){
        if(root==null){
            return;
        }
        
        path.add(root.data);

        if(root.left==null && root.right==null){
            printPath(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min,Node max){
        if(root==null){
            return true;
        }

        if(min!=null && root.data<=min.data){
            return false;
        }

        else if(max!=null && root.data>=max.data){
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static Node createMirror(Node root){
        if(root==null){
            return null;
        }

        Node leftMirror=createMirror(root.left);
        Node rightMirror=createMirror(root.right);

        root.left=rightMirror;
        root.right=leftMirror;
        return root;
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node creteBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node (arr[mid]);
        root.left=creteBST(arr, st, mid-1);
        root.right=creteBST(arr, mid+1, end);
        return root;
    }

    public static void getinorder(Node root, ArrayList<Integer>inorder){
        if(root==null){
            return;
        }
        getinorder(root.left, inorder);
        inorder.add(root.data);
        getinorder(root.right, inorder);
    }

    public static Node createBST2(ArrayList<Integer>inorder,int st,int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root=new Node (inorder.get(mid));
        root.left=createBST2(inorder, st, mid-1);
        root.right=createBST2(inorder, mid+1, end);
        return root;
    }

    public static Node BalancedBST(Node root){
        //inorder seq
        ArrayList<Integer> inorder=new ArrayList<>();
        getinorder(root, inorder);
        //soryed inorder-> balancd bst
        root=createBST2(inorder, 0, inorder.size()-1);
        return root;
    }

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST,int size,int min, int max){
        this.isBST=isBST;
        this.size=size;
        this.min=min;
        this.max=max;
        }
    }

    public static int maxBST=0;

    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size= leftInfo.size+rightInfo.size+1;
        int min = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));

        if(root.data<=leftInfo.max || root.data>=rightInfo.min){
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST=Math.max(maxBST,size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static Node mergeBSTs(Node root1,Node root2){
        //step1
        ArrayList<Integer> inorder1 =new ArrayList<>();
        getinorder(root1, inorder1);

        //step2
        ArrayList<Integer> inorder2 =new ArrayList<>();
        getinorder(root2, inorder2);

        //merge
        ArrayList<Integer>finalArr=new ArrayList<>();
        int i=0,j=0;
        while(i<inorder1.size() && j<inorder2.size()){
            if(inorder1.get(i)<=inorder2.get(j)){
                finalArr.add(inorder1.get(i));
                i++;
            }else{
                finalArr.add(inorder2.get(j));
                j++;
            }
        }

        while(i<inorder1.size()){
            finalArr.add(inorder1.get(i));
            i++;
        }
        while(j<inorder2.size()){
            finalArr.add(inorder2.get(j));
            j++;
        }

        //step 4 sorted AL-> balanced BST
        return createBST2(finalArr, 0, finalArr.size()-1);

    }

    public static void main(String args[]){
        // int values[]={5,1,3,4,2,7};

        // Node root=null;

        // for(int i=0; i<values.length; i++){
        //     root = insert(root, values[i]);
        // }

        // inorder(root);
        // System.out.println();


        // if(search(root, 1)){
        //     System.out.println("Found");
        // }else{
        //     System.out.println("not found");
        // }


        // root=delete(root, 1);
        // System.out.println();
        // inorder(root);


        //printInRange(root, 5, 12);


        //printRootToLeaf(root, new ArrayList<>());


        // if(isValidBST(root, null, null)){
        //     System.out.println("Valid");
        // }else{
        //     System.out.println("inValid");
        // }


        // root =createMirror(root);
        // preOrder(root);


        //BST P2

        // int arr[]={3,5,6,8,10,11,12};
        // Node root=creteBST(arr, 0, arr.length-1);
        // preOrder(root);


        // Node root=new Node(8);
        // root.left=new Node(6);
        // root.left.left=new Node(5);
        // root.left.left.left=new Node(3);

        // root.right=new Node(10);
        // root.right.right=new Node(11);
        // root.right.right.right=new Node(12);

        // root= BalancedBST(root);
        // preOrder(root);


        // Node root=new Node(50);
        // root.left=new Node(30);
        // root.left.left=new Node(5);
        // root.left.right=new Node(20);

        // root.right=new Node(60);
        // root.right.left=new Node(45);
        // root.right.right=new Node(70);
        // root.right.right.left=new Node(65);
        // root.right.right.right=new Node(80);

        // Info info= largestBST(root);
        // System.out.println(maxBST);


        Node root1=new Node(2);
        root1.left=new Node(1);
        root1.right=new Node(4);

        Node root2=new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);

        Node root=mergeBSTs(root1, root2);
        preOrder(root);



    }
}

