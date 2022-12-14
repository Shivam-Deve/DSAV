class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class CircularList {
    Node head;
    Node tail;
    int size;

    void insert(int data) {
        Node n = new Node(data, null);
        if (size == 0) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        n.next = head;
        size++;
    }

    Node search(int data) {
        if (head.data == data) {
            return head;
        }
        Node temp = head.next;
        while (temp != head) {
            if (temp.data == data) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    void searchAndDisplay(int data) {
        Node found = search(data);
        if (found == null) {
            System.out.println("Not Found");
            return;
        }
        System.out.print(found.data + " ");
        Node temp = found.next;
        while (temp != found) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        CircularList cl = new CircularList();
        cl.insert(5);
        cl.insert(4);
        cl.insert(2);
        cl.insert(9);
        cl.insert(6);
        cl.insert(3);
        cl.searchAndDisplay(3);
    }
}
