package FenwickTree;

public class Main {

    public static void main(String[] args) {
        int a[] = {1,3,5};
        NumArray num = new NumArray(a);
        num.sumRange(0,2);
        num.update(1,2);
        num.sumRange(0,2);
    }
}
