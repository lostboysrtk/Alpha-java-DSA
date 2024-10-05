
import java.util.*;
public class Loops {
    
    public static void main(String args[]){
/* 
int counter=1;
while(counter<=10){
    System.out.print(counter+" ");
    counter++;
Scanner sc = new Scanner(System.in);
int range = sc.nextInt();
int counter = 1;
while(counter <= range){
    System.out.print(counter + " ");
    counter++;
}
System.out.println();
*/


/*
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int sum = 0;
int i=1;
while(i <= n){
    sum = sum + i;
    i++;
}
System.out.println("Sum is :" + sum);
*/


//int i=1;
/*for(int i=1; i<=10; i++){
    System.out.println("Hey Itz Me!");
}
*/


/* 
for(int line = 1; line <= 4; line++)
System.out.println("****");
*/


/* 
int n=10899;
while(n>0){
    int lastdigit=n%10;
    System.out.print(lastdigit);
    n=n/10;
}
System.out.println();
*/

/* 
int n=10899;
int rev=0;
while(n>0){
    int lastdigit=n%10;
    rev=(rev*10)+ lastdigit;
    n=n/10;
}
System.out.print(rev);
*/

/* 
int counter = 1;
do{
    System.out.println("heya!");
    counter++;
}while(counter <=10);
*/

/* 
Scanner sc = new Scanner(System.in);
do{
    System.out.print("Enter your no.");
int n = sc.nextInt();
if(n%10==0){
    break;
}
System.out.println(n);
}while(true);
*/

/* 
for(int i = 1; i<=5; i++){
    if(i==3){
        continue;
    }
    System.out.println(i);
}
*/

/* 
Scanner sc = new Scanner(System.in);
do{
    System.out.print("Enter your no.");
    int n=sc.nextInt();
    if(n%10==0){
        continue;
    }
System.out.println("No. was:" +n);
}while(true);
*/



Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
if(n==2){
    System.out.print("n is prime");
}else{
    boolean isPrime = true;
    for(int i=2; i<=Math.sqrt(n); i++){
    if(n % i == 0){  //n is a multiple of i(i is not equal to 1 or n)
        isPrime = false;
    }
    }
    
    if(isPrime == true) {
        System.out.println("n is Prime");
    } else {
        System.out.println("n is not prime");
    }
}

}
}
