//P1,P2,P3 all in one

import java.util.LinkedList;
import java.util.*;

public class BinaryTreesP1{
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node builTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode=new Node(nodes[idx]);
            newNode.left=builTree(nodes);
            newNode.right=builTree(nodes);

            return newNode;
        }

        // public static void preorder(Node root){
        //     if(root==null){
        //         return;
        //     }
        //     System.out.print(root.data+" ");
        //     preorder(root.left);
        //     preorder(root.right);
        // }

        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelorder(Node root){
            if(root==null){
                return;
            }

            Queue<Node>q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode =q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }

    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }

        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }

    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftcount=count(root.left);
        int rightcount=count(root.right);
        return leftcount+rightcount+1;
    }

    public static int sumofNodes(Node root){
        if(root==null){
            return 0;
        }
        int rightsum=sumofNodes(root.right);
        int leftsum=sumofNodes(root.left);
        return rightsum+leftsum+root.data;

    }

    public static int diameter(Node root){ //o(n^2)
        if(root==null){
            return 0;
        }
        int leftDiam=diameter(root.left);
        int rightDiam=diameter(root.right);
        int LH=height(root.left);
        int RH=height(root.right);

        int selfDiam = LH+RH+1;

        return Math.max(selfDiam,Math.max(leftDiam,rightDiam));
    }

    static class Info{
        int diam;
        int ht;

        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }

    public static Info diameter2(Node root){
        if(root==null){
            return new Info(0, 0);
        }
        Info leftInfo= diameter2(root.left);
        Info righInfo= diameter2(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, righInfo.diam), leftInfo.ht+righInfo.ht +1);
        int ht =Math.max(leftInfo.ht, righInfo.ht)+1;

        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node node, Node subRoot){
        if(node==null && subRoot==null){
            return true;
        }else if(node == null || subRoot==null || node.data != subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot){
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static class Info2{
        Node node;
        int hd;
        public Info2(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    public static void topView(Node root){
        //level order
        Queue<Info2>q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();

        int min =0, max=0;
        q.add(new Info2(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info2 curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
            if(!map.containsKey(curr.hd)){ // first time my hd is occuring
                map.put(curr.hd, curr.node);
            }
    
            if(curr.node.left!=null){
                q.add(new Info2(curr.node.left, curr.hd-1));
                min=Math.min(min,curr.hd-1);
            }
            
            if(curr.node.right!=null){
                q.add(new Info2(curr.node.right,curr.hd+1));
                max=Math.max(max,curr.hd+1);
            }
            }
        }
        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    public static void Klevel(Node root, int level, int K){
        if(root==null){
            return;
        }

        if(level==K){
            System.out.print(root.data);
            return;
        }

        Klevel(root.left, level+1, K);
        Klevel(root.right, level+1, K);
    }

    public static boolean getPath(Node root,int n, ArrayList<Node>path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundright=getPath(root.right, n, path);

        if(foundLeft || foundright){
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }

    public static Node LCA(Node root, int n1,int n2){
        ArrayList<Node>path1=new ArrayList<>();
        ArrayList<Node>path2=new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        //last common ancestors
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }

        //last equal node -> i-1th
        Node LCA=path1.get(i-1);
        return LCA;
    }

    public static Node LCA2(Node root,int n1,int n2){
        if(root == null || root.data==n1 || root.data==n2){
            return root;
        }

        Node leftLCA2=LCA2(root.left, n1, n2);
        Node rightLCA2=LCA2(root.right,n1,n2);

        //leftLCA=val rightLCA=null
        if(rightLCA2==null){
            return leftLCA2;
        }
        if(leftLCA2==null){
            return rightLCA2;
        }

        return root;
    }

    public static int lcaDist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }

        int leftDist=lcaDist(root.left, n);
        int rightDist=lcaDist(root.right, n);

        if(leftDist==-1 && rightDist==-1){
            return -1;
        }else if(leftDist==-1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }


    public static int minDist(Node root,int n1,int n2){
        Node Lca=LCA2(root, n1, n2);
        int dist1=lcaDist(root,n1);
        int dist2=lcaDist(root,n2);

        return dist1+dist2;
    }


    public static int KAncestor(Node root,int n, int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }

        int leftDist= KAncestor(root.left,n,k);
        int rightDist= KAncestor(root.right,n,k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist,rightDist);
        if(max+1==k){
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transform(Node root){
        if(root==null){
            return 0;
        }
        int leftchild=transform(root.left);
        int rightchild=transform(root.right);
        int data= root.data;
        int newleft=root.left==null? 0:root.left.data;
        int newright=root.right==null?0:root.right.data;

        root.data=newleft+leftchild+newright+rightchild;

        return data;
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }


    public static void main(String args[]){

        // int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree=new BinaryTree();
        // Node root= tree.builTree(nodes);
        // System.out.println(root.data);

        //tree.preorder(root);
        //tree.inorder(root);
        //tree.postorder(root);
        //tree.levelorder(root);


        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left= new Node(4);
        root.left.right=new Node(5);
        root.right.left= new Node(6);
        root.right.right=new Node(7);

        Node subRoot = new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);

        //System.out.println(height(root));

        //System.out.println(count(root));

        //System.out.println(sumofNodes(root));

        //System.out.println(diameter(root));

        // System.out.println(diameter2(root).diam);
        // System.out.println(diameter2(root).ht);

        //System.out.println(isSubtree(root, subRoot));

        //topView(root);

        // int K=2;
        // Klevel(root,1,K);

        // int n1=4,n2=5;
        // System.out.println(LCA(root, n1, n2).data);

        // int n1=4,n2=7;
        // System.out.println(LCA2(root, n1, n2).data);

        // int n1=4,n2=6;
        // System.out.println(minDist(root, n1, n2));

        // int n=5,k=2;
        // KAncestor(root,n,k);

        transform(root);
        preorder(root);
    }
}