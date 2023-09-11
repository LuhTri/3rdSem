public class ListNode<E> {
    private E element;
    private ListNode<E> next;

    public ListNode() {}

    public ListNode(E item) {
        this(item, null);
        // element = item;
        // next = null;        
    }

    public ListNode(E item, ListNode<E> nextNode) {
        // this(item, nextNode);
        element = item;
        next = nextNode;
    }

    public E getElement() {
        return element;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }
}