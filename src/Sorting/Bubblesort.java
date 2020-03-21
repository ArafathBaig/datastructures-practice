package Sorting;

import java.util.Arrays;

public class Bubblesort {
  public static void main(String[] args) {
    int a[] ={83,12,41,5,78,43,78,55,33,2321,67,90,87,63,19,58,932,553};
    bubbleSort (a);
    System.out.println (Arrays.toString (a ) );
  }
  private static void bubbleSort(int a[]){
    int n = a.length;
    for(int i = 0 ; i < n ; i++){
      for(int j = i+1; j< n ; j++) {
        if (a[i] > a[j]) {
          int temp = a[i];
          a[i] = a[j];
          a[j] = temp;

        }
      }
    }
  }
}
