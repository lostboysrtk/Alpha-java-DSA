import java.util.Scanner;

public class Strings {
    public static void printletters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+ "");
        }
        System.out.println();
    }


    public static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            int n=str.length();
            if(str.charAt(i)!=str.charAt(n-1-i)){
                //not a paindrome
                return false;
            }
        }
        return true;
    }


    public static float getShortestPath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);
            //south
            if(dir=='S'){
                y--;
            }
            //north
            else if(dir=='N'){
                y++;
            }
            //west
            else if(dir=='W'){
                x--;
            }
            //east
            else{
                x++;
            }
        }

        int x2=x*x;
        int y2=y*y;
        return (float)Math.sqrt(x2+y2);

    }


    public static String substring(String str,int si,int ei){
        String substr="";
        for(int i=si;i<ei;i++){
            substr+=str.charAt(i);
        }
        return substr;
    }


    public static String toUpperCase(String str){
        StringBuilder sb=new StringBuilder("");
        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' '&&i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));   
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }


    public static String compress(String str){
        String newStr="";
        //aaabc
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newStr+=str.charAt(i);
            if(count>1){
                newStr+=count.toString();
            }
        }
        return newStr;
    }



    public static void main(String args[]){

    // String str="abcd";
    // String str2= new String("xyz");

    //input n output of strings

    // Scanner sc= new Scanner(System.in);
    // String name;
    // name=sc.nextLine();
    // System.out.println(name);


    //string length
    
    // String fullname="tony stark";
    // System.out.println(fullname.length());

    /*

    //concatenation

    String firstname="tony";
    String lastname="stark";
    String Fullname=firstname+" "+lastname;
    System.out.println(Fullname);


    //charAt
    System.out.println(Fullname.charAt(2));

    */


    /* 
    String firstname="tony";
    String lastname="stark";
    String Fullname=firstname+" "+lastname;
    printletters(Fullname);
    */


    /* 
    String str="racecar";
    System.out.println(isPalindrome(str));
    */

    
    /*
    String path="WNEENESENNN";
    System.out.println(getShortestPath(path));
    */

 
    //substring
    //String str="helloworld";
    //System.out.println(str.substring(0,5));
    //System.out.println(substring(str, 0, 5));


    /* 
    String fruits[]={"apple","mango","banana"};
    String largest=fruits[0];
    for(int i=1;i<fruits.length;i++){
        if(largest.compareTo(fruits[i])<0){
            largest=fruits[i];
        }
    }
    System.out.println(largest);
    */


    /* 
    StringBuilder sb=new StringBuilder("");
    for(char ch='a';ch<='z';ch++){
        sb.append(ch);
    }
    System.out.println(sb);
    */

    
    /*
    String str="hi, i am srtk";
    System.out.println(toUpperCase(str));
    */


    String str="aaabbcccdd";
    System.out.println(compress(str));








}
}
