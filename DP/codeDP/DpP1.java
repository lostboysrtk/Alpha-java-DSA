public class DpP1{
    public static int fibmemo(int n,int f[]){
        if(n==0||n==1){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n]=fibmemo(n-1, f)+fibmemo(n-2, f);
        return f[n];
    }

    public static int fibtabu(int n){
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int CountWaysRec(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return CountWaysRec(n-1)+CountWaysRec(n-2);
    }

    public static int CountWaysMemo(int n,int ways[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(ways[n]!=-1){ //already calc
            return ways[n];
        }

        ways[n]=CountWaysMemo(n-1, ways)+CountWaysMemo(n-2, ways);
        return ways[n];
    }

    public static int CountWaysTabu(int n){
        int dp[]=new int[n+1];
        dp[0]=1;

        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String args[]){
        int n=5;
        int f[]=new int [n+1];
        int ways[]=new int [n+1];

        //System.out.println(fibmemo(n, f));

        //System.out.println(fibtabu(n));

        //System.out.println(CountWaysRec(n));

        //System.out.println(CountWaysMemo(n, ways));

        System.out.println(CountWaysTabu(n));
    }
}