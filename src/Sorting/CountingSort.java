package Sorting;

import java.util.Arrays;
public class CountingSort {
  public static void main(String[] args) {

    int a[] = {23,12,13,6,31,47};
    countingSort (a,6,47);

    System.out.println(Arrays.toString(a));
  }
  private static void countingSort(int a[], int min , int max){
    int count[] = new int[(max-min)+1];
    for(int i = 0 ; i < a.length; i++){
      count[a[i]-min]++;
    }
    int j = 0;

    for(int i = min ; i <= max; i++){
      if(count[i-min]>0){
        a[j++] = i;
        count[i-min]--;
      }
    }
  }
}
