class Book {
    int bookId;
    String bookTitle;
    float price;

    Book(int id, String title, float price) {
        this.bookId = id;
        this.bookTitle = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id = " + this.bookId + " | Rs = " + this.price + " | Title = " + this.bookTitle;
    }
}

class Node {
    Book data;
    Node next;
    Node prev;

    Node(int id, String title, float price, Node next, Node prev) {
        data = new Book(id, title, price);
        this.next = next;
        this.prev = prev;
    }
}

class DList {
    Node head, tail;
    int size;

    void insert(int id, String title, float price) {
        Node n = new Node(id, title, price, null, null);
        if (size == 0) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }

    void delete(int id) {
        if (head.data.bookId == id) {
            head = head.next;
            head.prev = null;
        } else {
            Node temp = head;
            while (temp != null) {
                if (temp.data.bookId == id) {
                    temp.prev.next = temp.next;
                    size--;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    void search(String title) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.bookTitle == title) {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}

public class DoublyLinkedList {
    public static void main(String[] args) {
        DList dl = new DList();
        dl.insert(1, "Ramayan", 567.2f);
        dl.insert(2, "Mahabharat", 667.2f);
        dl.insert(3, "Gita", 467.2f);
        dl.insert(4, "Ramayan", 967.2f);
        dl.insert(5, "C++", 767.2f);
        dl.search("Ramayan");
        dl.delete(1);
        dl.display();
    }
}
