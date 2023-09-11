import java.util.*;

public class LinkedList<E> implements ListInterface<E> {
    private ListNode<E> head = null;
    private int numNodes = 0;

    public boolean isEmpty() {
        return numNodes == 0;
    }

    public int size() {
        return numNodes;
    }

    public E getFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Linked list is empty");
        }
        return head.getElement();
    }

    public boolean contains(E item) {
        for (ListNode<E> n = head; n != null; n = n.getNext()) {
            if (n.getElement().equals(item))
                return true;
        }
        return false;
    }

    public void addFirst(E item) {
        head = new ListNode<E>(item, head);
        numNodes++;
    }

    public E removeFirst() throws NoSuchElementException {
        ListNode<E> temp;
        if (head == null) {
            throw new NoSuchElementException("Linked list is empty");
        } else {
            temp = head;
            head = head.getNext();
            numNodes--;
            return temp.getElement();
        }
    }

    public E removeAfter(ListNode<E> current) throws NoSuchElementException {
        E temp;
        if (current != null) {
            ListNode<E> nextPtr = current.getNext();
            if (nextPtr != null) {
                temp = nextPtr.getElement();
                current.setNext(nextPtr.getNext());
                numNodes--;
                return temp;
            } else
                throw new NoSuchElementException("No next node to remove");
        } else { // if current is null, assume we want to remove head
            if (head != null) {
                temp = head.getElement();
                head = head.getNext();
                numNodes--;
                return temp;
            } else
                throw new NoSuchElementException("No next node to remove");
        }
    }

    public E remove(E item) throws NoSuchElementException {
        // ListNode<E> prev = head;
        // ListNode<E> curr = head.getNext();

        // for (ListNode<E> n = head; n != null; n = n.getNext()) {
        //     if (!(n.getElement().equals(item))) {
        //         prev = curr;
        //         curr = n.getNext();
        //     }
        //     else {
        //         removeAfter(prev);
        //         numNodes--;
        //     }
        // }

        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        else {
            if (head.getElement().equals(item)) {
                return removeFirst();
            }
            else {
                ListNode<E> prev, curr = head;

                for (int i = 0; i < numNodes - 1; i++) {
                    prev = curr;
                    curr = curr.getNext();

                    if (curr.getElement().equals(item)) {
                        numNodes--;
                        return removeAfter(prev);
                    }
                }
                throw new NoSuchElementException("Item not exist");
            }
        }
    }



    public void print() throws NoSuchElementException {
        if (head == null)
            throw new NoSuchElementException("Nothing to print...");

        ListNode<E> ln = head;
        System.out.print("List is: " + ln.getElement());
        for (int i = 1; i < numNodes; i++) {
            ln = ln.getNext();
            System.out.print(", " + ln.getElement());
        }
        System.out.println(".");
    }

}