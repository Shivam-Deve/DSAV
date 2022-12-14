import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String mail_id;
    float marks;

    Student(int roll, String name, String mail, float marks) {
        this.rollNo = roll;
        this.name = name;
        this.mail_id = mail;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return this.rollNo + "--" + this.name + "--" + this.mail_id + "--" + this.marks;
    }
}

class Node {
    Student data;
    Node next;

    Node(int roll, String name, String mail, float marks, Node next) {
        data = new Student(roll, name, mail, marks);
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

    void insert(int roll, String name, String mail, float marks) {
        Node n = new Node(roll, name, mail, marks, null);
        if (size == 0) {
            head = tail = n;
        } else {
            if (head.data.name.compareTo(name) > 0) {
                n.next = head;
                head = n;
            } else {
                Node temp = head.next;
                Node prev = head;
                while (temp != null && temp.data.name.compareTo(name) < 0) {
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

public class StudentListName {
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
                    System.out.println("Enter roll no.");
                    int roll = scn.nextInt();
                    System.out.println("Enter name");
                    String name = scn.next();
                    System.out.println("Enter mail");
                    String mail = scn.next();
                    System.out.println("Enter marks");
                    float marks = scn.nextFloat();
                    l.insert(roll, name, mail, marks);
                    break;
                case 2:
                    l.display();
                    break;
                case 3:
                    System.out.println("Enter roll no.");
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
