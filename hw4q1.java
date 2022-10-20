import javax.management.RuntimeErrorException;

public class hw4q1 {
    public static void main(String[] args) {
        double values[] = new double[] { 3, 4, 2, 6, 0.5 };
        String operations[] = new String[] { "+", "x", "+", "x" };
        double[][][] lel = dynamicProgramming(values, operations);

        double[][] m = lel[0];
        double[][] s = lel[1];
        System.out.println(arrayToString(m));
        System.out.println(arrayToString(s));

        int[][] sInt = new int[s.length][s.length];
        for(int i =0;i<s.length;i++){
            for(int j =0;j<s.length;j++){
                sInt[i][j] = (int) s[i][j];
            }
        }
       // printOptimalParens(values, operations, sInt, 0, sInt.length-1);
    }

    public static double[][][] dynamicProgramming(double[] values, String[] operations) {
        int n = values.length;
        double[][] m = new double[n][n];
        double[][] s = new double[n - 1][n - 1];

        for (int i = 0; i < n; i++) {
            m[i][i] = values[i];
        }

        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n - l ; i++) {
                //System.out.println("yye1");
                int j = i + l;
                //m[i][j] = 0;
                System.out.println(arrayToString(m));
                System.out.println(arrayToString(s));
                
                for (int k = i; k < j; k++) {
                   // System.out.println("yye1");
                    double left = m[i][k];
                    double right = m[k + 1][j];
                    String operation = operations[k];
                    double q = operationsParser(left, right, operation);
                    //System.out.println(q + "pain");
                    if (q > m[i][j]) {
                        m[i][j] = q;
                        s[i][j-1] = k;
                    }
                }
            }
        }

        return new double[][][] { m, s};
    }

    public static double operationsParser(double left, double right, String operation) {
        if (operation.equals("+")) {
            return left + right;
        }
        if (operation.equals("x")) {
            return left * right;
        } else {
            throw new RuntimeErrorException(null);
        }
    }

    public static String arrayToString(double[][] d) {
        String s = "";
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                s = s + d[i][j] + ", ";
            }
            s = s + "\n";
        }
        return s;
    }
    public static void printOptimalParens(double[] values, String[] operations, int[][] s,int i,int j){
        if(i==j){
            System.out.println(values[i] + " " + operations[i]);
        }
        else{
            System.out.println("(");
            printOptimalParens(values,operations,s,i,s[i][j]);
            printOptimalParens(values,operations,s,s[i][j]+1,j);
            System.out.println(")");
        }
    }

}
