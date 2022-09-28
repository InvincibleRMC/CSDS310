import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.util.Random;

class hw3q3{
public static void main(String[] args) {
    // d is sorted
    String dn =  "abcdefghijklmnop";
    String[] d =dn.split("");
   // String[] d = {"w","x","y","z"};
    
    // missing o
    //string remove =
    //String cn =  "legfihjdncamkpb";
  //  String[] c =cn.split("");
    //String[] c = {"y","z","w"};
   // int n = c.length;
    test(dn);
   // System.out.println(missingString(d, c,0, n));
    }

    public static void test(String dn){
        String[] d =dn.split("");
        
        for(int i=0;i<d.length;i++){
            List<String> cList = new ArrayList(Arrays.asList(d));
            String removed= (String) cList.remove(i);
            for(int j=0;j<100;j++){
            cList.add(cList.remove((int) Math.random()*cList.size()));
            }
            String[] c =  cList.toArray(new String[cList.size()]);
            System.out.println("Missing:=" + removed);
            String missing = missingString(d, c, 0, c.length);
            if(!missing.equals(removed)){
                throw new AssertionError(Arrays.asList(c) + " removed=" + removed + " missing=" + missing);
            }
            System.out.println("------------------------------------");
        }
    

    }

   public static String missingString(String[] d,String[] c,int low,int high){
    System.out.println(Arrays.asList(c).subList(low, high) + " " +low + " " +high);
   
    int pivotD = (low+high)/2;
    String pivotDVal = d[pivotD];

    int bestPivotValLocation=-10000;

    
    System.out.println("PivotValInC " + bestPivotValLocation + " PivotVal " + pivotDVal );

    
   // boolean left=();
    int pivotC = partition(d, c, low, high,pivotDVal);
   System.out.println(Arrays.asList(c).subList(low, high) + " " +low + " " +high);
   

    int leftAmountC = pivotC-low;
    int rightAmountC = high-pivotC;

    int leftAmountD = pivotD-low;
    int rightAmountD =high-pivotD;

    //System.out.println(Arrays.asList(c).subList(low, high) + " " +low + " " +high);
   

    for(int i =low;i<high;i++){
        if(c[i].equals(d[pivotC])){
            bestPivotValLocation=i;
            break;
        }
    }
    if(bestPivotValLocation==-10000){
        System.out.println("val is " + d[pivotC]);
        return d[pivotC];
    }
    
   System.out.println("pivotC= " + pivotC); //+ " d[pivotC]= " + d[pivotC] );
    System.out.println(" " + leftAmountC + " " + leftAmountD + " " + rightAmountC + " " + rightAmountD + " "  );
       
    //look right
    if(rightAmountC < leftAmountC){
        //pivotC= partition(d, c, bestPivotValLocation, high);
        //System.out.println(pivotC);
        System.out.println("looking right");
        return missingString(d, c, pivotC+1,high);
    }
    //look left
    else if (rightAmountC > leftAmountC){
       // pivotC= partition(d, c, low, bestPivotValLocation);
        System.out.println("looking left");
        return missingString(d, c, low,pivotC); 
    }
    
    
    
    //look right
        if(rightAmountC == rightAmountD){
            //pivotC= partition(d, c, bestPivotValLocation, high);
            //System.out.println(pivotC);
            System.out.println("looking right");
            return missingString(d, c, pivotC+1,high);
        }
        //look left
        else if (leftAmountC == leftAmountD){
           // pivotC= partition(d, c, low, bestPivotValLocation);
            System.out.println("looking left");
            return missingString(d, c, low,pivotC); 
        }
       return "yikes";
   }
    public static int partition(String[] d, String[] arr, int low, int high, String pivotDVal)
    {
       // int pivotD=(int) Math.ceil((low+high)/2);
       // String pivotDVal = d[pivotD];
        int pivotC = low;
        for (int i = low; i < high; i++) {
            // inserting elements of less value
            // to the left of the pivot location
            if (arr[i].compareTo(pivotDVal)<=0) {
                swap(arr, i, pivotC);
                pivotC++;
            }
        }
  
        // swapping pivot to the final pivot location
        swap(arr, high-1, pivotC);
        //System.out.println(pivotC);
        return pivotC;
    }

    public static void swap(String[] arr, int i, int j){
       //System.out.println("i:" +i + "j:" + j);
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int goodPivot(String[] d, String[] c, int l,int h){
        String lookingfor = d[(l+h)/2];
        System.out.println(lookingfor);
        for(int i=l;i<l;i++){
            if(lookingfor.compareTo(c[i])==0)
            {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

    public static boolean exists(String[] d , String c,int low,int high){

        for(int i =0;i<d.length;i++){
            if(c.equals(d[i])){
                return true;
            }
        }

        //System.out.println(Arrays.binarySearch(Arrays.sort(d), c) >= 0);
        return false;
    }

}
