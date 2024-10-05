public class BackTracking{

public static void changeArr(int arr[], int i, int val){
    //base case
    if(i==arr.length){
        printArr(arr);
        return;
    }
    //recursion or kaam
    arr[i]=val;
    changeArr(arr, i+1, val+1);
    arr[i]=arr[i]-2;           //baclTracking step
}

public static void printArr(int arr[]){
    for(int i=0; i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
}


public static void findSubSets(String str,String ans, int i){
    //base case
    if(i==str.length()){
        System.out.println(ans);
        return;
    }

    //yes choice
    findSubSets(str, ans+str.charAt(i), i+1);
    //no
    findSubSets(str, ans, i+1);
}


public static void findPermutation(String str, String ans){
    //base case
    if(str.length()==0){
        System.out.println(ans);
        return;
    }
    //recursion
    for(int i=0;i<str.length();i++){
    char curr=str.charAt(i);
    //abcde=> ab + de="abde"
    String newStr=str.substring(0,i)+str.substring(i+1);
    findPermutation(newStr, ans+curr);
    }
}

public static boolean isSafe(char board[][],int row,int col){
    //vertical up
    for(int i=row-1; i>=0;i--){
        if(board[i][col]=='Q'){
            return false;
        }
    }

    //diag lft up
    for(int i=row-1,j=col-1;i>=0 && j>=0; i--,j--){
        if(board[i][j]=='Q'){
            return false;
        }
    }

    //diag ryt up
    for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
        if(board[i][j]=='Q'){
            return false;
        }
    }

    return true;
}


public static void nQueens(char board[][],int row){
    //base
    if(row==board.length){
        printBoard(board);
        //instead of above line => count++
        return;
    }
    //colm loop
    for(int j=0;j<board.length;j++){

        if(isSafe(board,row,j)){//is safe lagaya extraaa

        board[row][j]='Q';
        nQueens(board, row+1);//fnc call or recurssion
        board[row][j]='.';//BackTracking
        }
    }
}

public static void printBoard(char board[][]){
    System.out.println("-------------chess board-------------");
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board.length;j++){
            System.out.print(board[i][j]+" ");
        }
        System.out.println();
    }
}

static int count=0; //for count type qus


public static int gridWays(int i,int j, int n,int m){
    //base case
    if(i==n-1 && j== m-1){ //condn for last cell
        return 1;
    }else if(i==n || j==m){// boundary cross condn
        return 0;
    }

    int w1=gridWays(i+1, j, n, m);
    int w2=gridWays(i, j+1, n, m);
    return w1+w2;
}
public static void main(String args[]){

    // int arr[]= new int[5];
    // changeArr(arr, 0, 1);
    // printArr(arr);


    // String str="abc";
    // findSubSets(str, "", 0);

    // String str="abc";
    // findPermutation(str, "");


    // int n=4;
    // char board[][]=new char[n][n];
    // //initialise
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //         board[i][j]='.';
    //     }
    // }

    // nQueens(board, 0);

    //System.out.println(count);   //for count type ques


    int n=4, m=4;
    System.out.println(gridWays(0, 0, n, m));



}
}