class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;
    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
class TicketSystem {
    TicketNode head = null;
    TicketNode tail = null;
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newNode = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public void removeTicket(int ticketId) {
        if (head == null) return;
        TicketNode current = head;
        TicketNode previous = tail;
        do {
            if (current.ticketId == ticketId) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else {
                    previous.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = previous;
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }
    public void displayTickets() {
        if (head == null) return;
        TicketNode temp = head;
        do {
            System.out.println(temp.ticketId + " " + temp.customerName + " " + temp.movieName + " " + temp.seatNumber + " " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }
    public void searchByCustomerOrMovie(String keyword) {
        if (head == null) return;
        TicketNode temp = head;
        do {
            if (temp.customerName.equals(keyword) || temp.movieName.equals(keyword)) {
                System.out.println(temp.ticketId + " " + temp.customerName + " " + temp.movieName + " " + temp.seatNumber + " " + temp.bookingTime);
            }
            temp = temp.next;
        } while (temp != head);
    }
    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}
public class TicketCircularLinkedList {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();
        system.addTicket(1, "Alice", "Avengers", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Batman", "B1", "11:00 AM");
        system.addTicket(3, "Charlie", "Avengers", "A2", "12:00 PM");
        system.displayTickets();
        System.out.println(system.countTickets());
        system.searchByCustomerOrMovie("Avengers");
        system.removeTicket(2);
        system.displayTickets();
        System.out.println(system.countTickets());
    }
}
