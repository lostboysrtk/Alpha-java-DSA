import java.util.*;

//// fnc classes etc

/* 
class BankAccount{
    public String username;
    private String password;
    public void setPassword(String pswrd){
        password=pswrd;
    }
}

class Pen{
    private String color;
    private int tip;

    String getColor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }

    void setColor(String newColor){
        color=newColor;
    }

    void setTip(int newTip){
        tip=newTip;
    }

    }
    */

        /*
        //constructors
        class Student{
            String name;
            int roll;
            String passsword;
            int marks[];

            //shallow copy constructor
            // Student(Student s1){
            //     marks=new int[3];
            //     this.name=s1.name;
            //     this.roll=s1.roll;
            //     this.marks=s1.marks;
            //}

            
            //deep copy constructor
            Student(Student s1){
                marks=new int[3];
                this.name=s1.name;
                this.roll=s1.roll;
                for(int i=0;i<marks.length;i++){
                this.marks[i]=s1.marks[i];
                }
            }


            Student(){
                marks=new int[3];
                System.out.println("constructoris called....");
            }
            Student(String name){
                marks=new int[3];
                this.name=name;
            }
            Student(int roll){
                marks=new int[3];
                this.roll=roll;
            }
            
        }
        */


        //Single line inheristance
        /* 
        //base class
        class Animal{
            String color;

            void eat(){
                System.out.println("eats");
            }

            void breathe(){
                System.out.println("breathes");
            }
        }

        //derived class or sub class
        class Fish extends Animal{
            int fins;

            void swim(){
                System.out.println("swims in water");
            }
            

        }
        */

        /*
        //multi lin einheritance

        class Animal{
            String color;

            void eat(){
                System.out.println("eats");
            }

            void breathe(){
                System.out.println("breathes");
            }
        }

        class Mammal extends Animal{
            int legs;
        }

        class Dog extends Mammal{
            String breeds;
        }
        */

        /* 
        //hierarchial inheritance

        class Animal{
            String color;

            void eat(){
                System.out.println("eats");
            }

            void breathe(){
                System.out.println("breathes");
            }
        }

        class Mammal extends Animal{
            void walk(){
                System.out.println("walks");
            }
        }

        class Fish extends Animal{
            void swim(){
                System.out.println("swim");
            }
        }

        class Bird extends Animal{
            void fly(){
                System.out.println("fly");
            }
        }
        */


        /* 
        class Calculator{
            int sum(int a, int b){
                return a+b;
            }

            float sum(float a,float b){
                return a+b;
            }

            int sum(int a,int b,int c){
                return a+b+c;
            }
        }

        class Animal{
            void eat(){
                System.out.println("eat anything");
            }
        }

        class dog extends Animal{
            void eat(){
                System.out.println("eat flash only");
            }
        }
        */


        /* 
        //abstraction
        abstract class Animal{
            void eat(){
                System.out.println("animal eats");
            }
            abstract void walk();

        }

        class Horse extends Animal{
            void walk(){
                System.out.println("walks on 4 legs");
            }
        }

        class Chicken extends Animal{
            void walk(){
                System.out.println("walks on 2 egs");
            }
        }
        */


        /* 
        interface ChessPlayer{
            void moves();
        }

        class Queen implements ChessPlayer{
            public void moves(){
                System.out.println("up,down,lft,ryt,diag");
            }
        }

        class Rook implements ChessPlayer{
            public void moves(){
                System.out.println("up,down,lft,ryt");
            }
        }

        class King implements ChessPlayer{
            public void moves(){
                System.out.println("up,down,lft,ryt,diag(1 step)");
            }
        }
        */


        /* 
        class Student{
            String name;
            int roll;
            static String schoolName;

            void setName(String name){
                this.name=name;
            }
            String getName(){
                return this.name;
            }
        }
        */

        class Animal {
            Animal(){
                System.out.println("animal constructor is called");
            }
        }

        class Horse extends Animal{
            Horse(){
                super();
                System.out.println("horse constructor is called");
            }
        }
public class OOPS {
    public static void main(String args[]){
        

        /* 
        //pen
        Pen p1=new Pen();//created a pen obj called p1
        p1.setColor("blue");
        System.out.println(p1.color);
        p1.setTip(5);
        System.out.println(p1.tip);
        //p1.setColor("yellow")
        p1.color="yellow";
        System.out.println(p1.color);
        */


        /* 
        //for getters n setters
        Pen p1=new Pen();//created a pen obj called p1
        p1.setColor("blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        //p1.setColor("yellow")
        p1.setColor("yellow");
        System.out.println(p1.getColor());
        */


        /* 
        //bankaccount
        BankAccount myAcc=new BankAccount();
        myAcc.username="sarthakshh";
        myAcc.setPassword("qwerty");
        */


        /* 
        //constructors
        Student s1=new Student("srtk");
        //System.out.println(s1.name);
        */


        /* 
        Student s1=new Student();
        Student s2=new Student("srtk");
        Student s3=new Student(345);
        */

        /* 
        Student s1=new Student();
        s1.name="srtk";
        s1.roll=453;
        s1.passsword="qwerty";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=80;

        Student s2=new Student(s1);//copy
        s2.passsword="xyz";
        s1.marks[2]=100;

        for(int i=0;i<3;i++){
            System.out.println(s2.marks[i]);
        }
        */


        /* 
        Fish shark = new Fish();
        shark.eat();
        */


        /* 
        Dog dobby=new Dog();
        dobby.eat();
        dobby.legs=4;
        System.out.println(dobby.legs);
        */


        /*
        Calculator calc=new Calculator();
        System.out.println(calc.sum(1,2));
        System.out.println(calc.sum((float).5,(float)2.6));
        System.out.println(calc.sum(1,2,3));
        */


        /* 
        dog d=new dog();
        d.eat();
        */

        /*
        Horse h= new Horse();
        h.eat();
        h.walk();

        Chicken c=new Chicken();
        c.eat();
        c.walk();
        */

        /* 
        Queen q=new Queen();
        q.moves();
        */


        /* 
        Student s1=new Student();
        s1.schoolName="jmv";

        Student s2=new Student();
        System.out.println(s2.schoolName);

        Student s3=new Student();
        s3.schoolName="abc";
        */

        Horse h=new Horse();

    }
    
}













