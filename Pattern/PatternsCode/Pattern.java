import java.util.*;
public class Pattern {

//for adv patterns 
    public static void hollow_rec(int totRows,int totCols){
        //outer loop
        for(int i=1;i<=totRows;i++){
            //inner columns
            for(int j=1; j<=totCols; j++){
    
                //cell (i,j)
                if(i==1 || i== totRows || j==1 || j== totCols){
                    //bundary cells
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                } 
            }
            System.out.println();
        }
    }


    public static void inverted_rotated_half_pyramid(int n){
        //outer
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();


        }
    }

    public static void inverted_rotated_half_pyramidwith_number(int n){
        //outer
        for(int i=1;i<=n;i++){
            //inner number
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();


        }
    }

    public static void floydstraingle(int n){
        //outer
        int counter=1;
        for(int i=1;i<=n;i++){
            //inner 
            for(int j=1;j<=i;j++){
                System.out.print(counter+" ");
                counter++;
            }
            System.out.println();
        }
    }

    public static void zeroone_traingle(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if( (i+j)%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int n){
        //1st half
        for(int i=1;i<=n;i++){
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            //spaces
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //2nd half
        for(int i=n;i>=1;i--){
             //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            //spaces
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            
            //stars
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void solidrhombus(int n){
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollowrhombus(int n){
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            //hollow rec stars
            for(int j=1;j<=n;j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n){
        //1st hslf
        for(int i=1;i<=n;i++){
            //spaces
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");

            }
            System.out.println();
        }
        //2n half
        for(int i=n;i>=1;i--){
            //spaces
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            //stars
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");

            }
            System.out.println();
        }        
    }



     





    




    
    public static void main(String args[]){


/*        
    for(int line=1; line<=4; line++){
        for(int star=1; star<=line; star++){
            System.out.print("*");
        }
        System.out.println();
    }
*/


/* 
int n = 4;
    for(int line=1; line<=n; line++){
        for(int star=1; star<=n-line+1; star++){
        System.out.print("*");
    }
    System.out.println();
}

*/


/* 
int n=4;
for(int line=1; line<=n; line++){
for(int number=1; number<=line; number++){
    System.out.print(number);
}
System.out.println();
}
*/


/* 
int n = 4;
char ch = 'A';
for(int line=1; line<=n; line++){
    for(int chars=1; chars<=line; chars++){
        System.out.print(ch);
        ch++;
    }
    System.out.println();
}

*/


//Advanced Patterns part 2

//hollow_rec(4, 5);

//inverted_rotated_half_pyramid(4);

//inverted_rotated_half_pyramidwith_number(5);

//floydstraingle(15);

//zeroone_traingle(5);

//butterfly(4);

//solidrhombus(5);

//hollowrhombus(7);

diamond(5);




}
}



    

