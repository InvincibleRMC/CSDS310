import java.util.Random;

class hw1q3{
public static void main(String[] args) {
    int m=(int) (10*Math.random());
    int n=(int) (10*Math.random());
    int M=m;
    int N=n;
    for(int j=0;j<100;j++){
    

    
     m=M;
     n=N;
    //int counter =0;

    boolean P1 = true;
    boolean P2 = true;
    Random rand = new Random();
    for(int i =1;i<=M+N-1;i++)
    {
        //counter++;
        if(rand.nextInt(m+n)<m){
            m--;
        P1 = true;
        }
        else{
            n--;
            P1=false;
        }
        if(rand.nextInt(m+n)<m){
            m--;
         P2 = true;
        }
        else{
            n--;
            P2=false;
        }

        if(P1!=P2){
            n++;
        }
        else if(P1=true){
            m++;
        }
        else if(P1=false){
            m++;
        }

    }
    System.out.println(M + " " + N );
    System.out.println(n + " " + m);
}
}
}