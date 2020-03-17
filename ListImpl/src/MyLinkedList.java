// Doubly-Linked list
public class MyLinkedList<E> {
    private int size;
    private Node head, tail;

    private static class Node<E> {
        E data;
        Node next;
        Node prev;
        Node(E data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(E data) {
        Node aux = head;
        if(!(aux.data == null ^ data == null)){
            if((aux.data == null && data == null) || aux.data.equals(data)){
                return true;
            }
        }

        for (int k = 0; k < size-1; k++) {
            aux = aux.next;
            if(!(aux.data == null ^ data == null)) {
                if ((aux.data == null && data == null)
                        || aux.data.equals(data)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add(E data) {
        Node node = null;
        if(isEmpty()){
            node= new Node(data,null,null);
            head = node;
        }else{
            node = new Node(data,null,tail);
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void add(int i, E data) {
        if(i < 0 || i  > size ){
            throw  new ArrayIndexOutOfBoundsException();
        }
        Node aux = null;
        Node newNode = null;
        if(i == size){
            aux = tail;
            newNode = new Node(data,null,aux);
            aux.next = newNode;
            tail = newNode;
            size ++;
            return;
        }

        aux = head;
        for (int k = 0; k < i; k++) {
            aux = aux.next;
        }
        if (i > 0) {
            newNode = new Node(data, aux, aux.prev);
            aux.prev.next = newNode;
            aux.prev = newNode;
        }else{
            newNode = new Node(data,aux,null);
            head = newNode;
            aux.prev = newNode;
        }
        size++;
    }

    public E remove(int i) {
        if(i < 0 || i  > size -1 ){
            throw  new ArrayIndexOutOfBoundsException();
        }
        Node aux = null;
        if(i == size-1){
            aux = tail;
            tail.prev.next = null;
            tail = tail.prev;
            size--;
            return (E)aux.data;
        }
        aux = head;
        for (int k = 0; k < i; k++) {
            aux = aux.next;
        }
        if (i > 0) {
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;

        }else{
            head = aux.next;
            aux.prev = null;
        }
        size--;
        return (E)aux.data;
    }

    public E get(int i) {
        Node aux = head;
        for (int k = 0; k < i; k++){
            aux = aux.next;
        }
        return (E)aux.data;
    }

    public E set(int i, E newData) {
        // should return the previous data
        Node aux = head;
        for (int k = 0; k < i; k++){
            aux = aux.next;
        }
        E previews = (E)aux.data;
        aux.data = newData;
        return previews;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(size == 0){
            sb.append("[]");
            return sb.toString();
        }
        Node aux = head;
        sb.append(String.format("Obj%d= %d",0,aux.data));
        for (int k = 0; k < size -1; k++){
            sb.append(String.format(", Obj%d= %d",k+1,aux.data));
            aux = aux.next;

        }
        return sb.toString();
    }
}
