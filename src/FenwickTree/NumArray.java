package FenwickTree;

class NumArray {

    private int[] tree;
    private int[] bit;
    private int n;
    public NumArray(int[] nums) {

        this.n = nums.length;
        this.tree = nums;


        bit = new int[n+1];
        for(int i = 0 ; i < n ;i++)
            init(i, tree[i]);
    }

    private void init(int i, int val){

        i++;
        while(i <= n){
            bit[i] += val;
            i += lsb(i);
        }
    }

    private int lsb(int i){
        return i&-i;
    }

    private int prefixSum(int i){
        int sum = 0;
        i++;
        while(i > 0){
            sum += bit[i];
            i -= lsb(i);
        }

        return sum;
    }

    public void update(int i, int val) {

        int diff = val - tree[i];
        tree[i] = val;
        init(i, diff);
    }

    public int sumRange(int i, int j) {
        return prefixSum(j) - prefixSum(i-1);
    }
}