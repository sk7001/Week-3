class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;
    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}
class RoundRobinScheduler {
    ProcessNode head;
    ProcessNode tail;
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode node = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
    }
    public void removeProcessById(int processId) {
        if (head == null) return;
        ProcessNode temp = head;
        ProcessNode prev = null;
        do {
            if (temp.processId == processId) {
                if (prev != null) prev.next = temp.next;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = prev;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    public void roundRobinSchedule(int timeQuantum) {
        ProcessNode temp = head;
        while (temp != null) {
            if (temp.burstTime > timeQuantum) {
                temp.burstTime -= timeQuantum;
                temp = temp.next;
            } else {
                removeProcessById(temp.processId);
                temp = (temp == null) ? null : temp.next;
            }
        }
    }
    public void displayProcesses() {
        if (head == null) return;
        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + " Burst Time: " + temp.burstTime + " Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}
public class RoundRobinCircularLinkedList {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 15, 2);
        scheduler.addProcess(3, 20, 3);
        scheduler.addProcess(4, 5, 4);
        scheduler.displayProcesses();
        scheduler.roundRobinSchedule(10);
        scheduler.displayProcesses();
        scheduler.removeProcessById(2);
        scheduler.displayProcesses();
    }
}
