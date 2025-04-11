/*
Problem 1
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

public class SinglyDoublyCircularLinkedList {
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
*/

/*
Problem 2
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next, prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

class MovieList {
    MovieNode head, tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode node = new MovieNode(title, director, year, rating);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode node = new MovieNode(title, director, year, rating);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode node = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        node.next = temp.next;
        node.prev = temp;
        temp.next.prev = node;
        temp.next = node;
    }

    public void removeByTitle(String title) {
        MovieNode temp = head;
        while (temp != null && !temp.title.equals(title)) temp = temp.next;
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
    }

    public void searchByDirectorOrRating(String director, double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equals(director) || temp.rating == rating)
                System.out.println(temp.title);
            temp = temp.next;
        }
    }

    public void updateRating(String title, double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = rating;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class SinglyDoublyCircularLinkedList {
    public static void main(String[] args) {
        MovieList list = new MovieList();
        list.addAtEnd("Movie1", "Dir1", 2020, 4.5);
        list.addAtEnd("Movie2", "Dir2", 2021, 3.5);
        list.displayForward();
        list.displayReverse();
        list.updateRating("Movie1", 5.0);
        list.removeByTitle("Movie2");
        list.displayForward();
    }
}
*/

/*
Problem 3
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

public class SinglyDoublyCircularLinkedList {
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
 */

/*
Problem 4
class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    ItemNode head;

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        ItemNode node = new ItemNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = node;
        } else {
            ItemNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }

    public void removeByItemId(int itemId) {
        if (head == null) return;
        ItemNode temp = head;
        ItemNode prev = null;
        while (temp != null) {
            if (temp.itemId == itemId) {
                if (prev != null) prev.next = temp.next;
                if (temp == head) head = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void updateQuantity(int itemId, int quantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByItemId(int itemId) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println(temp.itemName + " " + temp.itemId + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }

    public void display() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println(temp.itemName + " " + temp.itemId + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }

    public double totalInventoryValue() {
        double totalValue = 0;
        ItemNode temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        return totalValue;
    }
}

public class SinglyDoublyCircularLinkedList {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addAtEnd("Item1", 101, 10, 5.5);
        inventory.addAtEnd("Item2", 102, 20, 3.5);
        inventory.addAtEnd("Item3", 103, 15, 4.0);
        inventory.display();
        System.out.println("Total Inventory Value: " + inventory.totalInventoryValue());
        inventory.removeByItemId(102);
        inventory.display();
        inventory.updateQuantity(103, 25);
        inventory.display();
        inventory.searchByItemId(101);
    }
}
*/

/*
Problem 5
class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean availability;
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookId, boolean availability) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availability = availability;
        this.next = null;
        this.prev = null;
    }
}

class LibraryList {
    BookNode head;
    BookNode tail;

    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean availability) {
        BookNode node = new BookNode(title, author, genre, bookId, availability);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean availability) {
        BookNode node = new BookNode(title, author, genre, bookId, availability);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void removeBookById(int bookId) {
        if (head == null) return;
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    public void updateBookAvailability(int bookId, boolean availability) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.availability = availability;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayBooksForward() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.bookId + " " + temp.availability);
            temp = temp.next;
        }
    }

    public void displayBooksBackward() {
        BookNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.bookId + " " + temp.availability);
            temp = temp.prev;
        }
    }

    public void searchBookByTitleOrAuthor(String title, String author) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title) || temp.author.equals(author)) {
                System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.bookId + " " + temp.availability);
            }
            temp = temp.next;
        }
    }

    public void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }
}

public class SinglyDoublyCircularLinkedList {
    public static void main(String[] args) {
        LibraryList library = new LibraryList();
        library.addBookAtEnd("Book1", "Author1", "Genre1", 101, true);
        library.addBookAtEnd("Book2", "Author2", "Genre2", 102, false);
        library.addBookAtEnd("Book3", "Author3", "Genre3", 103, true);
        library.displayBooksForward();
        library.updateBookAvailability(102, true);
        library.displayBooksForward();
        library.removeBookById(101);
        library.displayBooksForward();
        library.countBooks();
    }
}
*/

/*
Problem 6
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

public class SinglyDoublyCircularLinkedList {
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
*/

/*
Problem 7
import java.util.*;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    UserNode head;

    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    public UserNode searchUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public UserNode searchUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(int userId1, int userId2) {
        UserNode user1 = searchUserById(userId1);
        UserNode user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        }
    }

    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = searchUserById(userId1);
        UserNode user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
        }
    }

    public void displayFriends(int userId) {
        UserNode user = searchUserById(userId);
        if (user != null) {
            for (int friendId : user.friendIds) {
                UserNode friend = searchUserById(friendId);
                if (friend != null) {
                    System.out.println(friend.userId + " - " + friend.name);
                }
            }
        }
    }

    public void mutualFriends(int userId1, int userId2) {
        UserNode user1 = searchUserById(userId1);
        UserNode user2 = searchUserById(userId2);
        if (user1 != null && user2 != null) {
            for (int id : user1.friendIds) {
                if (user2.friendIds.contains(id)) {
                    UserNode mutual = searchUserById(id);
                    if (mutual != null) {
                        System.out.println(mutual.userId + " - " + mutual.name);
                    }
                }
            }
        }
    }

    public int countFriends(int userId) {
        UserNode user = searchUserById(userId);
        if (user != null) {
            return user.friendIds.size();
        }
        return 0;
    }
}

public class SinglyDoublyCircularLinkedList {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Alice", 20);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 25);
        sm.addUser(4, "David", 21);
        sm.addUser(5, "Eve", 23);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(2, 4);
        sm.addFriend(3, 5);

        System.out.println("Alice's Friends:");
        sm.displayFriends(1);

        System.out.println("Bob's Friends:");
        sm.displayFriends(2);

        System.out.println("Mutual Friends of Alice and Bob:");
        sm.mutualFriends(1, 2);

        System.out.println("Number of friends for Charlie: " + sm.countFriends(3));

        sm.removeFriend(1, 2);

        System.out.println("Alice's Friends after removing Bob:");
        sm.displayFriends(1);
    }
}
*/

/*
Problem 8
class TextStateNode {
    String textState;
    TextStateNode next;
    TextStateNode prev;

    public TextStateNode(String textState) {
        this.textState = textState;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    TextStateNode currentState;
    TextStateNode undoState;
    TextStateNode redoState;

    public void addTextState(String textState) {
        TextStateNode node = new TextStateNode(textState);
        if (currentState != null) {
            currentState.next = node;
            node.prev = currentState;
        }
        currentState = node;
        redoState = null;
    }

    public void undo() {
        if (currentState != null && currentState.prev != null) {
            redoState = currentState;
            currentState = currentState.prev;
        }
    }

    public void redo() {
        if (redoState != null) {
            currentState.next = redoState;
            redoState.prev = currentState;
            currentState = redoState;
            redoState = null;
        }
    }

    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current Text: " + currentState.textState);
        }
    }
}

public class SinglyDoublyCircularLinkedList {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addTextState("Hello");
        editor.addTextState("Hello World");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
*/

/*
Problem 9
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

public class SinglyDoublyCircularLinkedList {
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
*/