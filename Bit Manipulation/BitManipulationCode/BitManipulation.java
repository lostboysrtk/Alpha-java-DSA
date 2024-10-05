import java.util.*;
public class BitManipulation {
    public static void oddOrEven(int n){
        int bitMask=1;
        if((n&bitMask)==0){
            //even
            System.out.println("even number");
        }else{//odd
            System.out.println("odd number");
        }
    }

    public static int getIthBit(int n,int i ){
        int bitMask=1<<i;
        if((n & bitMask)==0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int setIthBit(int n,int i){
        int bitMask=1<<i;
        return n|bitMask;
    }

    public static int clrIthBit(int n,int i){
        int bitMask=~(1<<i);
        return n&bitMask;
    }

    public static int updateIthBit(int n,int i, int newBit){
        // if(newBit==0){
        //     return clrIthBit(n,i);
        // }else{
        //     return setIthBit(n,i);
        // }
        //or
        n=clrIthBit(n, i);
        int bitMask=newBit<<i;
        return n|bitMask;
    }


    public static int clearIthBits(int n,int i){
        int bitMask=(~0)<<i;
        return n&bitMask;
    }


    public static int clrITHbitsRange(int n,int i,int j){
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int bitMask=a|b;
        return n&bitMask;
    }


    public static boolean isPowerofTwo(int n){
        return (n&(n-1))==0;
    }


    public static int countSetbits(int n){
        int count =0;
        while(n>0){
            if((n&1)!=0){
                //check our lSB
                count++;
            }
            n=n>>1;
        }
        return count;
    }


    public static  int fastExpo(int a,int n){
        int ans=1;
        while(n>0){
            if((n&1)!=0){
                //check LSB
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }




    public static void main(String args[]){

        /* 
        oddOrEven(3);
        oddOrEven(4);
        oddOrEven(5);
        */

        //System.out.println(getIthBit(10,2 ));

        // System.out.println(setIthBit(10,2 ));

        //System.out.println(clrIthBit(10, 1));

        //System.out.println(clearIthBits(15, 2));

        //System.out.println(clrITHbitsRange(10,2 ,4 ));

        //System.out.println(isPowerofTwo(15));

        //System.out.println(countSetbits(15));

        System.out.println(fastExpo(3, 5));
    }
    
}
