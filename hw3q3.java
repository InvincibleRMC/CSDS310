import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class hw3q3 {
    public static void main(String[] args) {
        String dn = "abcdefghijklmnop";
        test(dn);
    }

    public static void test(String dn) {
        String[] d = dn.split("");
        
        for (int i=0;i<d.length;i++) {
            List<String> cList = new ArrayList<String>(Arrays.asList(d));
            String removed = cList.remove(i);
            for (int j=0;j<100;j++) {
                cList.add(cList.remove((int) Math.random()*cList.size()));
            }
            String[] c =  cList.toArray(new String[cList.size()]);
            System.out.println("Missing:=" + removed);
            String missing = missingString(d, c);
            if (!missing.equals(removed)) {
                throw new AssertionError(Arrays.asList(c) + " removed=" + removed + " missing=" + missing);
            }
            System.out.println("------------------------------------");
        }
    }

    public static String missingString(String[] d, String[] c) {
        System.out.println("START  d=" + Arrays.asList(d));
        System.out.println("START  c=" + Arrays.asList(c));
        return missingString(d, 0, d.length,
                             c, 0, c.length);
    }
        
    public static String missingString(String[] d, int dLow, int dHigh,
                                       String[] c, int cLow, int cHigh) {
        // base case - only one element left in d, must be missing string
        if ((dHigh - dLow) == 1) {
            String missing = d[dLow];
            System.out.println("MISSING=" + missing);
            return missing;
        }

        System.out.println();
        System.out.println("BEFORE d=" + Arrays.asList(d).subList(dLow, dHigh) + " dLow=" +dLow + " dHigh=" +dHigh);
        System.out.println("BEFORE c=" + Arrays.asList(c).subList(cLow, cHigh) + "    cLow=" +cLow + " cHigh=" +cHigh);
        int pivotD = (dLow+dHigh)/2;
        String pivotDVal = d[pivotD];
        System.out.println("pivotD=" + pivotD + " pivotDval=" + pivotDVal);
    
        int pivotC = partition(c, cLow, cHigh, pivotDVal);
        System.out.println("pivotC=" + pivotC);
        System.out.println("AFTER  c=" + Arrays.asList(c).subList(cLow, cHigh) + " cLow=" +cLow + " cHigh=" +cHigh);

        int leftAmountD  = pivotD-dLow;
        int leftAmountC  = pivotC-cLow;
        System.out.println("leftAmountD=" + leftAmountD + " leftAmountC=" + leftAmountC);

        // look right
        if (leftAmountD == leftAmountC) {
            System.out.println("looking right in d");
            return missingString(d, pivotD, dHigh,
                                 c, pivotC, cHigh);
        }
        // look left
        else{
        System.out.println("looking left in d");
        return missingString(d, dLow, pivotD,
                             c, cLow, pivotC);
        }
    }

    // returns lower bound of right partition
    public static int partition(String[] arr, int low, int high, String value)
    {
        // System.out.println("PARTITION IN value=" + value + " arr=" + Arrays.asList(arr).subList(low, high));
        int pivot = low;
        for (int i = low; i < high; i++) {
            // inserting elements of less value
            // to the left of the pivot location
            if (arr[i].compareTo(value) < 0) {
                swap(arr, i, pivot);
                pivot++;
            }
            // System.out.println("PARTITION left=" + Arrays.asList(arr).subList(low, pivot)
            //                    + " value=" + value
            //                    + " right=" + Arrays.asList(arr).subList(pivot, high));
        }
        // System.out.println("PARTITION OUT arr=" + Arrays.asList(arr).subList(low, high) + " pivot=" + pivot);
        return pivot;
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}