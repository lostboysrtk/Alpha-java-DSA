import java.util.*;
public class Arrays {

    public static void update(int marks[]){
        for(int i=0; i<marks.length; i++){
            marks[i]=marks[i]+1;
        }
    }


    public static int linearSearch(int numbers[],int key){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    }


    public static int getLargest(int numbers[]){
        int largest = Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++){
            if(largest<numbers[i]){
                largest=numbers[i];
            }
            if(smallest>numbers[i]);{
                smallest=numbers[i];
            }
        }
        System.out.println("smallest value is:"+smallest); //printing it becauese we can only return one value
        return largest;
    }

    public static int binarySearch(int numbers[],int key){
        int start=0,end=numbers.length-1;
        while(start<=end){
            int mid=(start+end)/2;
    
        //compaare
        if(numbers[mid]==key){
            return mid;
        }
        if(numbers[mid]<key){
            start=mid;
        }else{
            end=mid-1;
        }
    }
        return -1;
    }

    public static void reverse(int numbers[]){
        int first =0,last =numbers.length-1;
        while(first<last){
            //swap
            int temp=numbers[last];
            numbers[last]=numbers[first];
            numbers[first]=temp;
            first++;
            last--;
        }
    }

    public static void printPairs(int numbers[]){
        int tp=0;
        for(int i=0;i<numbers.length;i++){
            int curr=numbers[i];//2,4,6,8,10
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("("+ curr + "," + numbers[j] + ")");
            tp++;
            }
            System.out.println(); 
        }
        System.out.println("total pairs=" +tp);
    }


    public static void printSubarrays(int numbers[]){
        
        int ts=0;

        for(int i=0; i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){//print
                    System.out.print(numbers[k]+" "); //subarrays
                }

                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total subarrays=" +ts);
    }

        public static void maxSubarrays(int numbers[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;

        for(int i=0; i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                currSum=0;
                for(int k=start;k<=end;k++){//print
                    //sum subarray
                    currSum+=numbers[k];
                }
                System.out.println(currSum);
                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println("max sum="+maxSum);
    }


    public static void maxSubarraysprefix(int numbers[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        int prefix[]=new int[numbers.length];

        //calc prefix array
        for(int i =1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+numbers[i];
        }

        for(int i=0; i<numbers.length;i++){
            int start=i;
            for(int j=i;j<numbers.length;j++){
                int end=j;
                currSum= start==0 ?prefix[end] :prefix[end]-prefix[start-1];

                /*
                for(int k=start;k<=end;k++){//print
                    //sum subarray
                    currSum+=numbers[k];
                }
                */

                System.out.println(currSum);
                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }
        System.out.println("max sum="+maxSum);
    }


    public static void kadanes(int numbers[]){
        int ms=Integer.MIN_VALUE;
        int cs=0;
        for(int i=0; i<numbers.length; i++){
            cs=cs+numbers[i];
            if(cs<0){
                cs=0;
            }
            ms=Math.max(cs,ms);
        }
        System.out.println("our max sub array sum:"+ms);
    }

    //Trapping Rainwater ques
    public static int trappedRainwater(int height[]){
        int n=height.length;
        //clc lft max boundary-array
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }

        //calc ryt max boundary-array
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        //loop
        int trappedwater=0;
        for(int i=0;i<n;i++){
            //waterlvl=min(lftmax boundary,rytmax boundary)
            int waterLevel=Math.min(leftMax[i],rightMax[i]);

            //trapped water =waterlvl-height[i]
            trappedwater+= waterLevel-height[i];
        }
        return trappedwater;
    }

    public static int buynsellStocks(int prices[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){//profit 
                int profit= prices[i]-buyPrice; //todays profit
                maxProfit= Math.max(maxProfit,profit);
            }else{
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }
    
    

    public static void main(String args[]){

        /* 
        //Creating arrays
        int marks[]= new int[50];
        int numbers[]={1,2,3};
        */


        //Input of an array
        
        /*
        int marks [] = new int[100];
        Scanner sc = new Scanner(System.in);
        */


        /* 
        marks[0]=sc.nextInt();
        marks[1]=sc.nextInt();
        marks[2]=sc.nextInt();

        System.out.println("phy:"+marks[0]);
        System.out.println("chem:"+marks[1]);
        System.out.println("math:"+marks[2]);
        */


        //System.out.println("length of array="+ marks.length);

    
        
        int marks[]={97,98,99};
        update(marks);

        //print our marks
        for(int i =0; i<marks.length;i++){
            System.out.print(marks[i]+" ");
        System.out.println();
        }

        /*

        int numbers[]={2,4,6,7,8,10,12,13,14};
        int key=12;

        int index = linearSearch(numbers,key);
        if(index==-1){
            System.out.println("Not Found");
        }else{
            System.out.println("Key is at Index:"+index);
        }

        */


        /* 
        int numbers[]={1,2,3,4,5,6,7};
        System.out.println("Largest value is:"+ getLargest(numbers));
        */ 

    
        /* 
        int numbers[]={2,3,4,5,6,7,8};
        int key=7;
        System.out.println("index for key is:"+ binarySearch(numbers,key));
        */


        /* 
        int numbers[]={2,3,4,5,6};
        reverse(numbers);
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
        */

        
        /* 
        int numbers[]={2,4,6,8,10};
        printPairs(numbers);
        */


        /* 
        int numbers[]={2,4,6,8,10};
        printSubarrays(numbers);
        */


        /* 
        int numbers[]={2,4,6,8,10};
        maxSubarrays(numbers);
        */


        /* 
        int numbers[]={1,-2,6,-1,3};
        maxSubarraysprefix(numbers);
        */


        /* 
        int numbers[]={-2,-3,4,-1,-2,1,5,-3};
        kadanes(numbers);
        */


        /*   
        int height[]={4,2,0,6,3,2,5};
        trappedRainwater(height);
        System.out.println(trappedRainwater(height));
        */

        
        /* 
        int prices[]={7,1,5,3,6,4};
        System.out.println(buynsellStocks(prices));
        */
        



    }
}

