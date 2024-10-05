import java.util.*;

public class DpP5 {
    public static boolean isMatch(String s,String p){
        int n=s.length();
        int m=p.length();

        boolean dp[][]=new boolean[n+1][m+1];

        //initialise
        dp[0][0]=true;
        //pattrn =" "
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        //s=" "
        for(int j=1;j<n+1;j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1];
            }
        }

        //bottom up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //case-> ith char==jth char||jth char==?
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }else{
                    dp[n][m]=false;
                }
            }
        }
        return dp[n][m];
    }

    public static int CatalanRec(int n){
        if(n==0||n==1){
            return 1;
        }
        int ans=0;  //Cn
        for(int i=0;i<=n-1;i++){
            ans+=CatalanRec(i)*CatalanRec(n-i-1);
        }
        return ans;
    }

    public static int CatalanMemo(int n,int dp[]){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=CatalanMemo(i, dp)*CatalanMemo(n-i-1, dp);
        }
        return dp[n]=ans;
    }

    public static int CatalanTabu(int n){
        int dp[]=new int [n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];  //ci=cj*ci-j-1
            }
        }
        return dp[n];
    }

    public static int CountBST(int n){
        int dp[]=new int [n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){ //ci->BST(i nodes)-> dp[i]
            for(int j=0;j<i;j++){
                int lft=dp[j];
                int ryt=dp[i-j-1];
                dp[i]+=lft*ryt;  //ci=cj*ci-j-1
            }
        }
        return dp[n];
    }

    public static int MountainRanges(int n){
        int dp[]=new int [n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){ //n pairs->mountain ranges-> dp[i] / ci
            for(int j=0;j<i;j++){
                int inside=dp[j];
                int outside=dp[i-j-1];
                dp[i]+=inside*outside;  //ci=cj*ci-j-1
            }
        }
        return dp[n];
    }

    public static void main(String args[]){

        // String s="baaabab";
        // String p="*****ba*****ab"; //true
        // System.out.println(isMatch(s, p));


        int n=4;
        //System.out.println(CatalanRec(n));

        int dp[]=new int [n+1];
        Arrays.fill(dp,-1);
        //System.out.println(CatalanMemo(n, dp));

        //System.out.println(CatalanTabu(4));

        //System.out.println(CountBST(n));

        System.out.println(MountainRanges(4));
    }
}
