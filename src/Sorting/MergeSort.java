package Sorting;

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int a[] = {22,11,53,73,49,91,67,51,31,200};
    split(a,0,a.length-1);

    System.out.println(Arrays.toString(a));
  }

  private static void split(int a[],int start, int end){
    if(end<=start){
      return ;
    }
    int mid = (start+end)/2;
    split(a,start,mid);
    split(a,mid+1,end);
    merge(a,start,mid,end);
  }


  private static void merge(int a[],int start, int mid, int end){
    int b[] = new int[end-start+1];
    int leftSlot = start;
    int rightSlot = mid+1;

    int k=0;

    while(leftSlot<=mid && rightSlot<= end){
      if(a[leftSlot] < a[rightSlot]){
        b[k] = a[leftSlot];
        leftSlot++;
      }else{
        b[k] = a[rightSlot];
        rightSlot++;
      }
      k++;
    }

    if(leftSlot<=mid){
      while(leftSlot<=mid) {
        b[k] = a[leftSlot];
        leftSlot++;
        k++;
      }
      }else if(rightSlot<=end){
        while (rightSlot<=end){
          b[k] = a[rightSlot];
          rightSlot++;
          k++;
        }
      }

      for(int i =0 ; i < b.length ; i++){
        a[start+i] = b[i];
      }
    }
  }

