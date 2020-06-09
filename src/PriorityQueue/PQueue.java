package PriorityQueue;

import java.util.*;

public class PQueue<T extends Comparable<T>> {

    private int heapSize = 0;
    private int heapCapacity = 0;
    private List<T> heap ;

    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public PQueue() {
        this(1);
    }

    public PQueue(int sz){
        heap = new ArrayList<>(sz);
    }

    public PQueue(T[] elems){
        heapSize = heapCapacity = elems.length;
        heap = new ArrayList<>(heapCapacity);

        for(int i = 0; i < heapSize ;i++){
            mapAdd(elems[i],i);
            heap.add(elems[i]);
        }

        for(int i = Math.max(0, heapSize/2)-1 ; i >= 0; i--)
            sink(i);

    }

    public PQueue(Collection<T> elems){
        this(elems.size());
        for(T ele : elems) add(ele);
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    public void clear(){
        for(int i = 0; i < heapCapacity ;i++){
            heap.set(i,null);
            heapSize = 0;
            map.clear();
        }
    }

    public int size(){
        return heapSize;
    }

    public T peek(){
        if(isEmpty()) return null;
        return heap.get(0);
    }

    public T poll(){
        return removeAt(0);
    }

    public boolean contains(T ele){
        if(ele == null) return false;
        return map.containsKey(ele);
    }

    public void add(T ele){

        if(ele == null) throw new IllegalArgumentException();

        if(heapSize< heapCapacity){
            heap.set(heapSize,ele);
        }else{
            heap.add(ele);
            heapCapacity++;
        }

        mapAdd(ele,heapSize);
        swim(heapSize);
        heapSize++;
    }

    private boolean less(int i, int j){

        T node1 = heap.get(i);
        T node2 = heap.get(j);

        return node1.compareTo(node2) <= 0;
    }

    private void swim(int k){
        int parent = (k-1)/2;

        swap(parent, k);
        k = parent;

        parent = (k-1)/2;
    }

    private void sink(int k){

        while(true){
            int left = 2*k + 1;
            int right = 2*k + 2;

            int smallest = left;

            if(right < heapSize && less(right, left))
                smallest = right;

            if(left>= heapSize|| less(k, smallest)) break;

            swap(smallest, k);
            k = smallest;
        }
    }

    private void swap(int i, int j){
        T i_ele = heap.get(i);
        T j_ele = heap.get(j);

        heap.set(i, j_ele);
        heap.set(j, i_ele);

        mapSwap(i_ele, j_ele, i , j);
    }

    private boolean remove(T element){

        if(element == null) return false;

        Integer index = mapGet(element);
        if(index != null) removeAt(index);
        return index != null;
    }

    private T removeAt(int i){

        if(isEmpty()) return null;

        heapSize--;
        T removed_data = heap.get(i);
        swap(i, heapSize);

        heap.set(heapSize, null);
        mapRemove(removed_data, heapSize);

        if(i == heapSize) return removed_data;

        T elem = heap.get(i);

        sink(i);
        if(heap.get(i).equals(elem))
            swim(i);

        return removed_data;
    }

    public boolean isMinHeap(int k){

        if(k >= heap.size()) return true;

        int left = 2 * k  + 1;
        int right = 2*k +1;
        if(left < heapSize && !less(k,left)) return false;
        if(right < heapSize && !less(k,right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    private void mapAdd(T value, int index){

        TreeSet<Integer> set = map.get(value);

        if(set == null){
            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);
        }
    else set.add(index);
    }

    private void mapRemove(T value, int index){
        TreeSet<Integer> set = map.get(value);
        set.remove(index);
        if(set.size() == 0) map.remove(value);
    }

    private Integer mapGet(T value){
        TreeSet<Integer> set = map.get(value);
        if(set != null) return set.last();
        return null;
    }

    private void mapSwap(T val1, T val2, int val1Index, int val2Index){
        Set<Integer> set1 = map.get(val1);
        Set<Integer> set2 = map.get(val2);

        set1.remove(val1Index);
        set2.remove(val2Index);

        set1.add(val2Index);
        set2.add(val1Index);
    }
}
