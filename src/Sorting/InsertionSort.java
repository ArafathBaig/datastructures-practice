package Sorting;

import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) {
    int a[] = {11, 56, 74, 32, 83, 21, 61};
    insertionSort (a);
    System.out.println(Arrays.toString(a));
  }
  private static void insertionSort(int a[]){
    int n = a.length;

    for(int i = 0 ; i < n;i++){
      int j = i-1;
      int element = a[i];

      while(j>=0 && a[j]>element){
        a[j+1] = a[j];
        j--;
      }
      a[j+1] = element;
    }
  }
}
