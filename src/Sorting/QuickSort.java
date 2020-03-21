package Sorting;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {

    int a[] = {22,11,53,73,49,91,67,51,69};
    sort(a,0,a.length-1);

    System.out.println(Arrays.toString(a));
  }

  private static void sort(int a[], int start, int end) {
    if (start < end) {
      int partPoint = partition (a, start, end);
      sort (a, start, partPoint - 1);
      sort (a, partPoint + 1, end);
    }
  }

    private static int partition(int a[], int start,int end){
      int i = start - 1;
      int pivot = a[end];
      for(int j =  start ; j <= end ; j++ ){
        if(a[j]<pivot){
          i++;
          int ival = a[i];
          int jval = a[j];
          a[i] = jval;
          a[j] = ival;
        }
      }

      i++;
      int ival = a[i];
      a[i] = pivot;
      a[end] = ival;

      return i;
    }
  }

