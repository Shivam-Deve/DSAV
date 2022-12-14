import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    float marks;

    Student(int roll, String name, float marks) {
        this.rollNo = roll;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return this.rollNo + "--" + this.name + "--" + "--" + this.marks;
    }
}

class Node {
    Student data;
    Node next;

    Node(int roll, String name, float marks, Node next) {
        data = new Student(roll, name, marks);
        this.next = next;
    }
}

class List {
    Node head, tail;
    int size;

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    void delete(int roll) {
        if (head.data.rollNo == roll) {
            head = head.next;
        } else {
            Node temp = head.next;
            Node pre = head;
            while (temp != null) {
                if (temp.data.rollNo == roll) {
                    pre.next = temp.next;
                    size--;
                    return;
                }
                pre = temp;
                temp = temp.next;
            }
        }
    }

    void insert(int roll, String name, float marks) {
        Node n = new Node(roll, name, marks, null);
        if (size == 0) {
            head = tail = n;
        } else {
            if (head.data.marks < marks) {
                n.next = head;
                head = n;
            } else {
                Node temp = head.next;
                Node prev = head;
                while (temp != null && temp.data.marks > marks) {
                    prev = temp;
                    temp = temp.next;
                }
                n.next = temp;
                prev.next = n;
            }
        }
        size++;
    }
}

public class StudentListMark {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List l = new List();
        int option;
        boolean run = true;
        while (run) {
            System.out.println("Enter: 1 for insert | 2 for display | 3 for delete | 4 for exit");
            option = scn.nextInt();
            switch (option) {
                case 1:
                    int roll = scn.nextInt();
                    String name = scn.next();
                    float marks = scn.nextFloat();
                    l.insert(roll, name, marks);
                    break;
                case 2:
                    l.display();
                    break;
                case 3:
                    int r = scn.nextInt();
                    l.delete(r);
                    break;
                case 4:
                    run = false;
                default:
                    break;
            }
        }
    }
}
