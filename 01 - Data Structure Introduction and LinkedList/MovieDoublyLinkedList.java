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
public class MovieDoublyLinkedList {
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
