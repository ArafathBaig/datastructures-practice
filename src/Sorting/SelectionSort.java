package Sorting;

import java.util.Arrays;

public class SelectionSort {
  public static void main(String[] args) {
    int a[] = {1,81,31,44,12,69,92,77,11,7};
    selectionSort(a);
    System.out.println (Arrays.toString (a) );
  }
  private static void selectionSort(int a[]){
    for(int i = a.length-1 ;i >=0 ; i--){
      int smallest = i;
      for(int j = 1 ; j <= i ; j++){
        if(a[j]>a[smallest]){
          smallest = j;
        }
      }
      int temp= a[i];
      a[i] = a[smallest];
      a[smallest]  = temp;
    }
  }
}
