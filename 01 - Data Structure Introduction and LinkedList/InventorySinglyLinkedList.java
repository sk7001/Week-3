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
public class InventorySinglyLinkedList {
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
