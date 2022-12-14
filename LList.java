class Student {
    String name;
    int roll;
    public Student next;

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
        this.next = null;
    }

}

class LinkedList {
    private int size;
    private Student head;
    private Student tail;

    public void addLast(String name, int roll) {
        Student newStudent = new Student(name, roll);
        if (this.size == 0) {
            this.head = this.tail = newStudent;
        } else {
            this.tail.next = newStudent;
            tail = newStudent;
        }
        this.size++;
    }

    public void addFirst(String name, int roll) {
        Student newStudent = new Student(name, roll);
        if (this.size == 0) {
            this.head = this.tail = newStudent;
        } else {
            newStudent.next = head;
            head = newStudent;
        }
        this.size++;
    }

    public void display() {
        Student temp = this.head;
        while (temp != null) {
            System.out.println(temp.name + " with roll " + temp.roll);
            temp = temp.next;
        }
    }

}

public class LList {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.addLast("amit", 1);
        llist.addLast("Harsh", 2);
        llist.addLast("ramit", 3);
        llist.addFirst("Arya", 0);
        llist.display();
    }
}