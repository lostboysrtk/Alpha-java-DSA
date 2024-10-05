public class DpP3 {
    
    public static int coinChange(int coins[],int sum){
        int n=coins.length;
        int dp[][]=new int[n+1][sum+1];

        //initialise - sum is 0
        //i-> coins; j->sum/change

        for(int i=0;i<n+1;i++){
            dp[i][0]=1;
        }

        for(int j=1;j<sum+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<=j){//valid
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }else{
                    //invalid
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static int rodCutting(int lenght[],int price[],int totrod){
        int n=price.length;
        int dp1[][]=new int[n+1][totrod+1];

        for(int i=0;i<totrod;i++){
            for(int j=0;j<totrod;j++){
                if(i==0||j==0){
                    dp1[i][j]=0;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<totrod+1;j++){
                //valid
                if(lenght[i-1]<=j){
                    dp1[i][j]=Math.max(price[i-1]+dp1[i][j-lenght[i-1]],dp1[i-1][j]);
                }else{
                    //invalid
                    dp1[i][j]=dp1[i-1][j];
                }
            }
        }
        return dp1[n][totrod];
    }

    public static int LCSrec(String str1,String str2,int n,int m){
        if(n==0||m==0){
            return 0;
        }

        if(str1.charAt(n-1)==str2.charAt(m-1)){
            //same
            return LCSrec(str1, str2, n-1, m-1)+1;
        }else{
            //diff
            int ans1=LCSrec(str1, str2, n-1, m);
            int ans2=LCSrec(str1, str2, n, m-1);
            return Math.max(ans1,ans2);
        }
    }

    public static int LCSmemo(String str1,String str2,int n,int m,int dp2[][]){
        if(n==0||m==0){
            return 0;
        }

        if(dp2[n][m]!=-1){
            return dp2[n][m];
        }

        if(str1.charAt(n-1)==str2.charAt(m-1)){
            //same
            return dp2[n][m]=LCSmemo(str1, str2, n-1, m-1,dp2)+1;
        }else{
            //diff
            int ans1=LCSmemo(str1, str2, n-1, m,dp2);
            int ans2=LCSmemo(str1, str2, n, m-1,dp2);
            return dp2[n][m]=Math.max(ans1,ans2);
        }
    }

    public static int LCStabu(String str1,String str2){
        int n=str1.length();
        int m=str2.length();

        int dp3[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0||j==0){
                    dp3[i][j]=0;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp3[i][j]=dp3[i-1][j-1]+1;
                }else{
                    int ans1=dp3[i-1][j];
                    int ans2=dp3[i][j-1];
                    dp3[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        return dp3[n][m];
    }

    public static void main(String args[]){
        // int coins[]={1,2,3};
        // int sum=4;
        //System.out.println(coinChange(coins, sum));


        // int length[]={1,2,3,4,5,6,7,8};
        // int price[]={1,5,8,9,10,17,17,20};
        // int totrod=8;
        //System.out.println(rodCutting(length, price, totrod));


        String str1="abcdge";
        String str2="abedg";
        //System.out.println(LCSrec(str1, str2, str1.length(), str2.length()));


        // int n=str1.length();
        // int m=str2.length();
        // int dp2[][]=new int[n+1][m+1];
        // //initialise
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<m+1;j++){
        //         dp2[i][j]=-1;
        //     }
        // }
        //System.out.println(LCSmemo(str1, str2, n, m, dp2));

        
        //System.out.println(LCStabu(str1, str2));
    }
}
