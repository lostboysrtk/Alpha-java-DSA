public class RecurssionBasics {

    public static void printdec(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printdec(n-1);
    }

    public static void printinc(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printinc(n-1);
        System.out.print(n+" ");  
    }

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        int fnM1= fact(n-1);
        int fn=n*fact(n-1);
        
        return fn;
    }

    public static int calSum(int n){
        if(n==1){
            return 1;
        }
        int Snm1= calSum(n-1);
        int Sn=n+Snm1;
        
        return Sn;
    }

    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        int fnM1=fibonacci(n-1);
        int fnm2=fibonacci(n-2);
        int fn=fnM1+fnm2;
        return fn;
    }

    public static boolean isSorted(int arr[], int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }

    public static int firstOccurence(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        if (arr[i]==key){
            return i;
        }
        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        int isFound =lastOccurence(arr, key, i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    

    public static int power(int x,int n){
        if(n==0){
            return 1;
        }

        // int xnM1=power(x,n-1);
        // int xn=x*xnM1;
        // return xn;

        return x*power(x,n-1);
    }

    public static int optimisedPower(int a,int n){
        if(n==0){
            return 1;
        }

        //int halfPowerSq=optimisedPower(a,n/2)*optimisedPower(a, n/2);

        int halfPower=optimisedPower(a, n/2);
        int halfPowerSq=power(halfPower,2);

        if(n%2!=0){
            halfPowerSq=a*halfPowerSq;
        }
        return halfPowerSq;
    }

    public static int tilingProb(int n){
        if(n==0||n==1){
            return 1;
        }
        
        //vertically
        int fnM1=tilingProb(n-1);
    
        //horizontally
        int fnM2=tilingProb(n-2);

        int totways=fnM1+fnM2;
        return totways;
    }

    public static void removeDuolicate(String str, int idx, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newStr);
                return;
        }
        char currChar=str.charAt(idx);
        if(map[currChar-'a']==true){
            //duplicate
            removeDuolicate(str, idx+1, newStr, map);
        }else{
            map[currChar-'a']=true;
            removeDuolicate(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int frndPair(int n){
        //base case
        if(n==1||n==2){
            return n;
        }
        //single choice
        int fnM1=frndPair(n-1);
        //pair choice
        int fnM2=frndPair(n-2);
        
        //total ways
        int totways=fnM1+((n-1)*fnM2);
        return totways;
    }

    public static void printBinStr(int n,int lastplace,String str){
        //base case
        if(n==0){
            System.out.println(str);
            return;
        }
        //kaam

        printBinStr(n-1,0, str+"0");
        if(lastplace==0){
            printBinStr(n-1,1, str+"1");

        }
    }


    

    
        
    
    

public static void main (String args[]){
    
    //printdec(100);

    //printinc(10);

    // fact(6);
    // System.out.println(fact(6));

    // calSum(6);
    // System.out.println(calSum(6));

    // int n=20;
    // System.out.println(fibonacci(n));

    // int arr[]={1,2,3,4,5};
    // System.out.println(isSorted(arr, 0));

    // int arr[]= {4,5,6,3,8,4,9,4};
    // System.out.print(firstOccurence(arr,8, 0));

    // int arr[]= {4,5,6,3,8,4,9,4};
    // System.out.print(lastOccurence(arr,8, 0));

    //System.out.print(power(5, 3));

    //System.out.print(optimisedPower(2, 5));

    //System.out.println(tilingProb(4));

    // String str="appnnnacollleg";
    // removeDuolicate(str, 0, new StringBuilder(""), new boolean[26]);

    //System.out.print(frndPair(3));

    printBinStr(3, 0,"");

}
}
