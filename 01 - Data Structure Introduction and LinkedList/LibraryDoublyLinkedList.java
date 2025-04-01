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
public class LibraryDoublyLinkedList {
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
