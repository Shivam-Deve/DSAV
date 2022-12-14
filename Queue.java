class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class List {
    protected Node head, tail;
    protected int size;

    protected void addLast(int data) {
        Node n = new Node(data, null);
        if (size == 0) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    protected Node removeFirst() {
        if (size == 0) {
            return null;
        }
        Node temp = head;
        head = head.next;
        size--;
        return temp;
    }
}

class LinearQueue extends List {
    int peek() {
        return this.head.data;
    }

    int size() {
        return this.size;
    }

    void add(int data) {
        this.addLast(data);
    }

    int remove() {
        Node n = this.removeFirst();
        if (n == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return n.data;
    }

}

public class Queue {
    public static void main(String[] args) {
        LinearQueue lq = new LinearQueue();
        lq.add(5);
        lq.add(6);
        lq.add(9);
        int a = lq.remove();
        int b = lq.remove();
        int c = lq.remove();
        int d = lq.remove();
        System.out.println(a + " " + b + " " + c + " " + d + " ");
    }
}
