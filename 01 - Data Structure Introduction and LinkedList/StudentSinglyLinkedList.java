class StudentNode {
    int roll;
    String name;
    int age;
    char grade;
    StudentNode next;
    public StudentNode(int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentList {
    StudentNode head;
    public void addAtBeginning(int roll, String name, int age, char grade) {
        StudentNode node = new StudentNode(roll, name, age, grade);
        node.next = head;
        head = node;
    }
    public void addAtEnd(int roll, String name, int age, char grade) {
        StudentNode node = new StudentNode(roll, name, age, grade);
        if (head == null) head = node;
        else {
            StudentNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }
    public void addAtPosition(int pos, int roll, String name, int age, char grade) {
        if (pos == 1) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        StudentNode node = new StudentNode(roll, name, age, grade);
        StudentNode temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp == null) return;
        node.next = temp.next;
        temp.next = node;
    }
    public void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.roll == roll) {
            head = head.next;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.roll != roll) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }
    public void searchByRoll(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println(temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }
    }
    public void updateGrade(int roll, char grade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = grade;
                return;
            }
            temp = temp.next;
        }
    }
    public void display() {
        StudentNode temp = head;
        while (temp != null) {
            System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }
}
public class StudentSinglyLinkedList {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.addAtEnd(1, "Sobhit", 20, 'A');
        list.addAtEnd(2, "Sridhar", 21, 'B');
        list.display();
        list.updateGrade(1, 'C');
        list.display();
        list.deleteByRoll(2);
        list.display();
    }
}
