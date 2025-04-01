class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;
    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
class TaskScheduler {
    TaskNode head;
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode node = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = node;
            node.next = head;
        }
    }
    public void removeByTaskId(int taskId) {
        if (head == null) return;
        TaskNode temp = head;
        TaskNode prev = null;
        do {
            if (temp.taskId == taskId) {
                if (prev != null) prev.next = temp.next;
                if (temp == head) head = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    public void display() {
        if (head == null) return;
        TaskNode temp = head;
        do {
            System.out.println(temp.taskId + " " + temp.taskName + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    public void searchByPriority(int priority) {
        TaskNode temp = head;
        do {
            if (temp.priority == priority) System.out.println(temp.taskId + " " + temp.taskName);
            temp = temp.next;
        } while (temp != head);
    }
    public void viewCurrentTask() {
        if (head != null) {
            System.out.println("Current Task: " + head.taskName);
            head = head.next;
        }
    }
}
public class TaskCircularLinkedList {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addAtEnd(1, "Task1", 5, "2025-04-20");
        scheduler.addAtEnd(2, "Task2", 3, "2025-04-21");
        scheduler.addAtEnd(3, "Task3", 2, "2025-04-22");
        scheduler.display();
        scheduler.removeByTaskId(2);
        scheduler.display();
        scheduler.viewCurrentTask();
        scheduler.display();
    }
}
