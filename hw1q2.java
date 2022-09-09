import java.util.Arrays;
//import java.util.Random;

class hw1q2{
public static void main(String[] args) {
    int x= 20;
    int n =10;
    int[] A = magicArray(n);
    int[] B = magicArray(n);
    int counter=0;
    boolean foundX=false;
        int i =1;
        int j =n;
        while(i<n && j>1){
            counter++;
            if(A[i-1]+B[j-1]==x){
                foundX=true;
                break;
            }
            else if(A[i-1]+B[j-1]<x){
                i++;
            }
            else{
                j--;
            }

        }

        for (int element: A) {
            System.out.print(element);
        }
        System.out.println();
        for (int element: B) {
            System.out.print(element);
        }

        System.out.println();
        if(foundX){
            System.out.println("n= "+ n +" i= "+ i + " j= " + j +" x= "+ x);
        }
        else{
        System.out.println(false);
        }

        System.out.println(counter);
}


static int[] magicArray(int length){
    int[] sorted =new int[length];
    for(int i =0; i<sorted.length;i++){
        sorted[i] = (int) (Math.random()*20);
    }
    Arrays.sort(sorted);
    return sorted;
}

}

