class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class List {
    Node head, tail;
    int size;

    void addFirst(int data) {
        Node n = new Node(data, null);
        if (size == 0) {
            head = tail = n;
        } else {
            n.next = head;
            head = n;
        }
        size++;
    }

    void addLast(int data) {
        Node n = new Node(data, null);
        if (size == 0) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    Node removeFirst() {
        if (size == 0) {
            System.out.print("List is empty");
            return null;
        }
        Node temp = head;
        
        return null;
    }

    Node removeLast() {

        return null;
    }

}

public class LinkedList {
    public static void main(String[] args) {

    }
}