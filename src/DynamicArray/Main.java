package DynamicArray;

public class Main {
    public static void main(String[] args) {
        DArray<Integer> list= new DArray<>(0);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.removeAt(2);
        list.removeObject(1);

        String s = list.toString();

        System.out.println(s);
    }
}
