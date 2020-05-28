package DynamicArray;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DArray <T> implements Iterable<T> {

    private T a[];
    private int len ;
    private int capacity;

    public DArray(){
        this.capacity = 16;
        this.len = 0;
        a = (T[]) new Object[capacity];
    }

    public DArray(int capacity){

        if(capacity < 0) throw new RuntimeException("Capacity must be a greater than or equal to 0");
        this.capacity = capacity;
        this.len = 0;
        a = (T[]) new Object[capacity];
    }

    public int size(){
        return len;
    }

    public T get(int index){
        return a[index];
    }

    public void set(int index, T ele){
        a[index] = ele;
    }

    public void clear(){
        for(int i = 0; i < len ;i++){
            a[i] = null;
        }
        len = 0;
    }

    public void add(T ele){

        if(len + 1 >= capacity) {

            if (capacity == 0)
                capacity = 1;
            else
                capacity *= 2;
            T newArr[] = (T[]) new Object[capacity];
            for(int i = 0; i < len; i++) {
                newArr[i] = a[i];
            }
            a = newArr;
        }
        a[len++] = ele;
    }

    public T removeAt(int rmIndex){

        if(rmIndex >= len || rmIndex < 0) throw new IndexOutOfBoundsException();

        T data = a[rmIndex];
        T newArr[] = (T[])new Object[len-1];

        for(int i = 0, j = 0; i < len && j < len ; i++, j++){

            if(i == rmIndex) j--;
            else newArr[j] = a[i];
        }
        a = newArr;
        len = len - 1;
        capacity = len;
        return data;
    }

    public boolean removeObject(Object data){

        for(int i = 0 ; i < len ;i++){
            if(a[i].equals(data)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj){
        for(int i = 0; i < len ;i++){
            if(a[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        int t = indexOf(obj);
        return t>= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator <T>(){
            int index = 0;
            public boolean hasNext() { return index < len;}
            public T next(){return a[index++];}
        };
    }

    @Override
    public String toString() {
        if(len == 0) return "[]";

        StringBuilder sb = new StringBuilder(len).append("[");
        for(int i = 0; i < len-1 ;i++){
            sb.append(a[i]+", ");
        }
        sb.append(a[len-1] +"]");
        return sb.toString();
    }
}
