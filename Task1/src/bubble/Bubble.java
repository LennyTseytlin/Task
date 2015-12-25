package bubble;
import java.util.Scanner;

public class Bubble {
     public static void main(String[] args) {
        double a[] = parse(args);
        bubble(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
     
    public static boolean bubble(double arr[]) {
      boolean swapped = true;
      int j = 0;
      double tmp;
      while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {                                       
                  if (arr[i] > arr[i + 1]) {                          
                        tmp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = tmp;
                        swapped = true;
                  }
            }       
      }
     return swapped;
    }
    
    private static double[] parse(String[] input) {
        double res[] = new double[input.length];
        for (int i = 0; i < input.length; i++)
            res[i] = Double.parseDouble(input[i]);
        return res;
    }    
}
