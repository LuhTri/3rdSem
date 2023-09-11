import java.util.*;

public class TestLinkedList {
    public static void main(String[] args) throws NoSuchElementException {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.remove(4);
        list.print();
    }
}
